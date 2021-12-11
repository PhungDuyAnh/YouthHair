app.controller("employee-ctrl",function($scope,$http){

    
	$scope.items = [];
    $scope.cates = [];
    $scope.form = {};
    
   
    
	$scope.form.fullName = "";
    $scope.form.gender = "";
    $scope.form.salary = "";
    $scope.form.phone = "";
    $scope.form.address = "";
	$scope.form.statusWork = "";
	$scope.form.role = "";
	$scope.form.startDate = "";

    $scope.seachEmployee={
        fullName:''
    }

    $scope.doSubmitForm = function(event) {
        alert("OK: " + $scope.myForm.$submitted);

    }
    
    
    
    
    $scope.disabledBtnReset = false;
	$scope.disabledBtnUpdate = false;
	$scope.disabledBtnDelete = false;
	$scope.disabledBtnCreate = false;
	


    $scope.initialize = function(){
        //load product
        $http.get(`/rest/employee/seachEmployee?fullName=${$scope.seachEmployee.fullName}`).then(resp => {
            $scope.items = resp.data;
            $scope.reset();
            $scope.items.forEach(item => {
                item.startDate = new Date(item.startDate);
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
		startDate:new Date(),
		image:'undraw_profile.svg',
		statusWork:true,
		
		};
		
		
		$scope.disabledBtnUpdate = true;
		$scope.disabledBtnDelete = true;
		$scope.disabledBtnReset = false;
		$scope.disabledBtnCreate = false;
		
    }
    
    
 
    
    
    
    //hien thi len form,sau do quay ve tab 0
    $scope.edit = function(item){
        item.createDate = new Date(item.createDate);
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show');
        
        $scope.disabledBtnReset = false;
        $scope.disabledBtnCreate = true;
		$scope.disabledBtnUpdate = false;
		$scope.disabledBtnDelete = false;
		
    }
    
    
    //them sp moi
    $scope.create = function(){
	    var item = angular.copy($scope.form);
        $http.post(`/rest/employee`,item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm mới thành công!");
            location.reload(); 
            $(".nav-tabs a:eq(1)").tab('show');
            
        })
    }
    
    
    
    
    //cap nhat sp
    $scope.update = function(){
	    var item = angular.copy($scope.form);
        $http.put(`/rest/employee/${item.id}`,item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;            
            $scope.reset();
            alert("Cập nhật nhân viên thành công!");
            location.reload();
            
            $(".nav-tabs a:eq(1)").tab('show');
        })
    }
    
    
    
    
    
    
    //xoa sp
    
    $scope.delete = function(item){
    if(confirm("Bạn có muốn xoá liên hệ này không?")){
        $http.delete(`/rest/employee/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index,1);
            $scope.reset();
            alert("Xóa nhân viên thành công!");
            location.reload(); 
            $(".nav-tabs a:eq(1)").tab('show');
        }).catch(error => {
            alert("Không thể xóa nhân viên này!");
            console.log("Error",error);
        });
    }
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
    
    
    
    
    
    
    
    
    $scope.disabledBtnFisrt = false;
	$scope.disabledBtnLast = false;
	$scope.disabledBtnNext = false;
	$scope.disabledBtnPrev = false;
    
    
    $scope.sizePage = [5,10,15,20];
    
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
            return Math.ceil(1.0 *$scope.items.length / this.size);
        },

        
        get setPage(){
			return this.first();
		},
        first(){
        	this.page = 0;
        	$scope.disabledBtnFisrt = true;
			$scope.disabledBtnLast = false;
        },
        prev(){
        	this.page--;
        	if(this.page<=0){
        		this.first();
        	}
        },
        next(){
        	this.page++;
        	if(this.page+1>=this.count){
        		this.last();
        	}
        },
        last(){
        	this.page = this.count - 1;
        	$scope.disabledBtnFisrt = false;
			$scope.disabledBtnLast = true;
        }
	}

    //tim kiem
    $scope.seachEmployeeByName=function (){
        var item=angular.copy($scope.seachEmployee);
        $scope.seachEmployee.fullName =item.fullName;
        $scope.pager.first();
        $scope.initialize();
    }
	



})