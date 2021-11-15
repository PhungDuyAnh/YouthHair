app.controller("booking-ctrl",function($scope,$http){
	$scope.items=[];
	$scope.form=[];
	$scope.initialize=function (){
		//load booking
		$http.get("/rest/booking").then(resp=>{
			$scope.items=resp.data;
		})
	}

	$scope.initialize();

	$scope.reset=function (){
		$scope.form={

		}
	}


	//phan trang
	$scope.pager = {
		page: 0,
		size: 10,
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