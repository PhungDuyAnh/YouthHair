app.controller("contact-ctrl",function($scope,$http){
	
	$scope.items=[];
	$scope.form={};
	$scope.statusContact = '';
	
	$scope.initialize=function (){
		//load contacts
		$http.get(`/rest/contact/${$scope.statusContact}`).then(resp=>{
			$scope.items = resp.data;
		});
	}

	//show data into form
	$scope.showDetail = function(item){
		$scope.form = angular.copy(item);
		var input = document.getElementsByName("status");
		if($scope.form.status == true){		
			input[0].setAttribute("disabled", "disabled");
		}else{
			input[0].removeAttribute("disabled")
		}
	}
	
	$scope.loadTableDXL = function(){
		$scope.statusContact = 'DXL';
		$scope.initialize();
		$scope.pager.first();
	}
	
	$scope.loadTableCXL = function(){
		$scope.statusContact = 'CXL';
		$scope.initialize();
		$scope.pager.first();
	}
	
	//update contact
    $scope.update = function(){
	    var item = angular.copy($scope.form);
			
        $http.put(`/rest/contact/${item.id}`,item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert("Cập nhật liên hệ thành công!");
			$scope.pager.first();
			$scope.initialize();
			$(".close").click();
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
	            alert("Xóa liên hệ thành công!");
				$scope.pager.first();
				$scope.initialize();
	        }).catch(error => {
	            alert("Lỗi xóa liên hệ!");
	            console.log("Error",error);
	        });
		}
    }
	
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
		first(){
			this.page = 0;
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
		}
	}
	
	
	//start
	$scope.initialize();
})