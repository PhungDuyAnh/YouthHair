app.controller("bill-ctrl",function($scope,$http){
	
	$scope.items=[];
	$scope.form={};
	$scope.statusBooking = 'CPM';
	
	
	$scope.initialize = function (){
		//load contacts
		$http.get(`/rest/booking/${$scope.statusBooking}`).then(resp=>{
			$scope.items = resp.data;
		});
	}	
	
	$scope.showDetail = function(item){
		$scope.form={};
		$scope.form = angular.copy(item);
	}
	
	$scope.loadTableCPM = function(){
		$scope.statusBooking = 'CPM';
		$scope.pager.first();
		$scope.initialize();
	}
	
	$scope.loadTableCAN = function(){
		$scope.statusBooking = 'CAN';
		$scope.pager.first();
		$scope.initialize();
	}
	
	$scope.sizePage = [2,4,6];
	//phan trang
	$scope.pager = {
		page: 0,
		size: 2,
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