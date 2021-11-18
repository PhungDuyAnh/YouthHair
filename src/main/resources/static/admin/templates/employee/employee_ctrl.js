app.controller("employee-ctrl",function($scope,$http){

    
	$scope.items = [];
    $scope.cates = [];
    $scope.form = {};


    $scope.initialize = function(){
        //load product
        $http.get("/rest/employee").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        });
        //load categories
         $http.get("/rest/role").then(resp => {
            $scope.cates = resp.data;
        });
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
		$scope.form = {
		createDate:new Date(),
		image:'"/img/undraw_profile.svg"',
		ivailable:true,
		};
    }
    //hien thi len form,sau do quay ve tab 0
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show');
    }
    
    
    //them sp moi
    $scope.create = function(){
	    var item = angular.copy($scope.form);
        $http.post(`/rest/employee`,item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm mới thành công!");
        }).catch(error => {
            alert("Lỗi thêm mới nhân viên!");
            console.log("Error",error);
        }); 
    }
    //cap nhat sp
    $scope.update = function(){
	    var item = angular.copy($scope.form);
        $http.put(`/rest/employee/${item.id}`,item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            $scope.reset();
            alert("Cập nhật nhân viên thành công!");
        }).catch(error => {
            alert("Lỗi cập nhật nhân viên!");
            console.log("Error",error);
        });
    }
    //xoa sp
    $scope.delete = function(item){
        $http.delete(`/rest/employee/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index,1);
            $scope.reset();
            alert("Xóa nhân viên thành công!");
        }).catch(error => {
            alert("Lỗi xóa nhân viên!");
            console.log("Error",error);
        });
    }
    //upload hinh
    $scope.imageChanged = function(files){
		var data = new FormData();
		data.append('file',files[0]);
		$http.post('/rest/upload/images',data,{
            transformRequest: angular.identity,
            headers: {'Content-Type':undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            alert("Upload Image False!");
            console.log("Error",error);
        })
    }
    //phan trang
    $scope.pager = {
        page: 0,
      
        size:5,
        get items(){
            var start = this.page * this.size;
            return $scope.items.slice(start,start + this.size);
        },
        get count(){
        //tong so sp chia kich thuoc trang
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