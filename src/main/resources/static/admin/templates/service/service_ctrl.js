app.controller("service-ctrl",function($scope,$http){
    $scope.items=[];
    $scope.form={};
    $scope.time={
        value: new Date(1970, 0, 1, 14, 57, 0)
    };
    $scope.initialize=function (){
        //load booking
        $http.get("/rest/services").then(resp=>{
            $scope.items=resp.data;
        })
    }

    $scope.initialize();

    $scope.reset=function (){
        $scope.form={

        }
    }

    //them sp
    $scope.create = function() {
        var item = angular.copy($scope.form);
        const value = moment($scope.form.time).format('DD/MM/yyyy HH:mm:ss');
        item.time= value;
        $http.post(`/rest/services`,item).then(resp =>{

            // resp.data.time = new Date(value);
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm dịch vụ thành công ");
        }).catch(error =>{

            alert("Thêm mới dịch vụ thất bại ");
            console.log("Error" , error);
        });
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
            alert("Loi upload hinh anh");
            console.log("Error" ,error);
        })
    }


    //phan trang
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