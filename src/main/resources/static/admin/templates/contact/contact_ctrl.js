app.controller("contact-ctrl",function($scope,$http){
	
	$scope.items=[];
	$scope.form={};
	
	$scope.initialize=function (){
		//load customer
		$http.get("/rest/contact").then(resp=>{
			$scope.items = resp.data;
		});
	}
	//khoi dau
	$scope.initialize();

	
	//xoa form
	$scope.reset = function(){
		$scope.form = {
			
		};
	}

	//hien thi len form
	$scope.edit = function(item){
		$scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show');
	}


	//phan trang
	$scope.pager = {
		page: 0,
		size: 1,
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