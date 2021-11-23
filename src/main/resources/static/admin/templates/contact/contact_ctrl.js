app.controller("contact-ctrl",function($scope,$http){
	
	$scope.items=[];
	$scope.form={};
	
	$scope.disabledBtnReset = false;
	$scope.disabledBtnUpdate = false;
	$scope.disabledBtnDelete = false;
	
	$scope.initialize=function (){
		//load contacts
		$http.get("/rest/contact").then(resp=>{
			$scope.items = resp.data;
		});
		$scope.reset();
	}	
	
	//reset form
	$scope.reset = function(){
		$scope.form = {
			status: true
		};
		$(".nav-tabs a:eq(1)").tab('show');
		$scope.disabledBtnUpdate = true;
		$scope.disabledBtnDelete = true;
		$scope.disabledBtnReset = false;
	}

	//show data into form
	$scope.edit = function(item){
		$scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show');		
			
		$scope.disabledBtnReset = true;
		$scope.disabledBtnUpdate = false;
		$scope.disabledBtnDelete = false;
	}
	
	//update contact
    $scope.update = function(){
	    var item = angular.copy($scope.form);
			
        $http.put(`/rest/contact/${item.id}`,item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            $scope.reset();
            alert("Cập nhật liên hệ thành công!");
        }).catch(error => {
            alert("Lỗi cập nhật liên hệ!");
            console.log("Error",error);
        });
    }

	//delete contact
	$scope.delete = function(item){
		if(confirm("Bạn có muốn xoá liên hệ này không?")){
	        $http.delete(`/rest/contact/${item.id}`).then(resp => {
	            var index = $scope.items.findIndex(p => p.id == item.id);
	            $scope.items.splice(index,1);
	            $scope.reset();
	            alert("Xóa liên hệ thành công!");
	        }).catch(error => {
	            alert("Lỗi xóa liên hệ!");
	            console.log("Error",error);
	        });
		}
    }

	$scope.disabledBtnFisrt = false;
	$scope.disabledBtnLast = false;
	$scope.disabledBtnNext = false;
	$scope.disabledBtnPrev = false;
	
	$scope.sizePage = [3,6,9,11];
	//phan trang
	$scope.pager = {
		page: 0,
		size: 3,
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
			$scope.disabledBtnFisrt = true;
			$scope.disabledBtnLast = false;
		},
		prev(){
			this.page--;
			if(this.page <= 0){
				this.first();
			}
		},
		next(){
			this.page++;
			if(this.page+1 >= this.count){
				this.last();
			}
		},
		last(){
			this.page = this.count - 1;
			$scope.disabledBtnFisrt = false;
			$scope.disabledBtnLast = true;
		}
	}
	
	
	//start
	$scope.initialize();
})