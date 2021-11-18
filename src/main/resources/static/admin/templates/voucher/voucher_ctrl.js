app.controller("voucher-ctrl",function($scope,$http){
	$scope.items=[];
	$scope.form={};
	$scope.initialize=function (){
		$http.get("/rest/voucher").then(resp=>{
			$scope.items=resp.data;
		})
	}

	$scope.initialize();

	$scope.reset= function(){
		$scope.form = {};
	}
	//hien thi len form
	$scope.edit = function(item){
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show');
	}

	//them voucher moi
	$scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/voucher`,item).then(resp => {
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm mới thành công!");
		}).catch(error => {
			alert("Thêm mới không thành công!");
			console.log("Error",error);
		});
	}
	//cap nhat voucher
	$scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/voucher/${item.id}`,item).then(resp => {
			var index = $scope.items.findIndex(p => p.id === item.id);
			$scope.items[index] = item;
			$scope.reset();
			alert("Chỉnh sửa thông tin voucher thành công!");
		}).catch(error => {
			alert(" Chỉnh sửa thông tin voucher không thành công!");
			console.log("Error",error);
		});
	}
	//xoa voucher
	// $scope.delete = function(item){
	// 	$http.delete(`/rest/voucher/${item.id}`).then(resp => {
	// 		var index = $scope.items.findIndex(p => p.id == item.id);
	// 		$scope.items.splice(index,1);
	// 		$scope.reset();
	// 		alert("Xóa sản phẩm thành công!");
	// 	}).catch(error => {
	// 		alert("Lỗi xóa sản phẩm!");
	// 		console.log("Error",error);
	// 	});
	// }


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
