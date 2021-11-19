app.controller("customer-ctrl",function($scope,$http){
	$scope.items=[];
	$scope.form=[];
	$scope.initialize=function (){
		//load customer
		$http.get("/rest/customer").then(resp=>{
			$scope.items=resp.data;
		})
	}

	$scope.initialize();

	$scope.reset=function (){
		$scope.form={

		}
	}
	
	//hien thi len form
	$scope.edit = function(item){
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show');
	}
	
	//xoa reset form
	//$scope.reset = function(){
			//$scope.form = {
				
				
			//};
	//}
	
	//cap nhat 
	$scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/customer/${item.id}`,item).then(resp => {
			var index = $scope.items.findIndex(p => p.id === item.id);
			$scope.items[index] = item;
			$scope.reset();
			alert("Chỉnh sửa thông tin thành công!");
		}).catch(error => {
			alert(" Chỉnh sửa thông tin không thành công!");
			console.log("Error",error);
		});
	}
	



	//phan trang
	$scope.pager = {
		page: 0,
		size: 7,
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