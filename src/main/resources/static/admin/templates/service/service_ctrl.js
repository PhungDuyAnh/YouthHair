app.controller("service-ctrl",function($scope,$http){
    $scope.items=[];
    $scope.seach={
        searchText: " "
    };
    $scope.form={};
    $scope.initialize=function (){
        //load service
        $http.get("/rest/services").then(resp=>{
            $scope.items=resp.data;
        })
    }

    $scope.seachServiceByName=function (){
        var item = angular.copy($scope.seach);
        $http.get(`/rest/services/seach/?serviceName=${item.searchText}`).then(resp=>{
            $scope.items=resp.data;
        })
    }

    $scope.initialize();
    $scope.reset=function (){
        $scope.form={
            image: "Add.png",
            status: true
        }
    }
    $scope.reset();

    //update
    $scope.update = function() {
        var item = angular.copy($scope.form);
        const value = moment($scope.form.time).format('DD/MM/yyyy HH:mm:ss');
        item.time= value;
        $http.post(`/rest/services`,item).then(resp =>{

            // resp.data.time = new Date(value);
            $scope.items.push(resp.data);
            $scope.reset();
            $scope.initialize();
            alert("Cập nhập vụ thành công ");
        }).catch(error =>{

            alert("Cập nhập dịch vụ thất bại ");
            console.log("Error" , error);
        });
    }

    //hien thi len form
    $scope.edit = function(item){
        item.time= new Date("1970-01-01 "+item.time);
        $scope.form = angular.copy(item);
        $scope.initialize();
        $(".nav-tabs a:eq(0)").tab('show');
    }


    //upload
    $scope.imageChanged = function(files) {
        var data = new FormData();
        data.append("file",files[0]);
        $http.post('/rest/upload/images', data,{
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp =>{
            $scope.form.image = resp.data.name
            alert($scope.form.image);
        }).catch(error => {
            alert("Lỗi update hình ảnh");
            console.log("Error" ,error);
        })
    }


    //phan trang
    $scope.sizePage = [5,10,15,20];
    $scope.pager = {
        page: 0,
        size: 5,
        get items(){
            var start = this.page * this.size;
            return $scope.items.slice(start,start + this.size);
        },
        get count(){
            return Math.ceil(1.0 *$scope.items.length / this.size)
        },
        get setPage(){
            return this.first();
        },
        first(){
            this.page = 0;
        },
        prev(){
            this.page--;
            if(this.page<0){
                this.last();
            }
        },
        next(){
            this.page++;
            if(this.page>=this.count){
                this.first();
            }
        },
        last(){
            this.page = this.count - 1;
        }
    }
})