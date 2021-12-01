app.controller("booking-ctrl",function($scope,$http,$timeout,$q){
	$scope.items=[];
	$scope.items1=[];
	$scope.items2=[];
	$scope.form={};
	$scope.form1={
	};
	$scope.form2={};
	$scope.form3={};
	$scope.form5={};
	$scope.sizePage = [5,10,15,20];
	$scope.employee=[];
	$scope.employee1=[];
	$scope.itemWaiting=[];
	$scope.initialize=function (){
		//load booking
		$http.get("/rest/booking/WFC").then(resp=>{
			$scope.items=resp.data;
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate);
			})
		})

		$http.get("/rest/booking/WFP").then(resp=>{
			$scope.items1=resp.data;
			$scope.items1.forEach(item => {
				item.createDate = new Date(item.createDate)
			})
		})

		$http.get("/rest/booking/UCF").then(resp=>{
			$scope.items2=resp.data;
			$scope.items2.forEach(item => {
				item.createDate = new Date(item.createDate)
			})
		})

		$http.get("/rest/booking/stylist").then(resp=>{
			$scope.employee=resp.data;
		})

		$http.get("/rest/booking/employee").then(resp=>{
			$scope.employee1=resp.data;
		})

	}

	$scope.showBookingWating=function (item){
		$http.get("/rest/booking/stylist/waiting").then(resp=>{
			$scope.itemWaiting=resp.data;
			return $scope.itemWaiting.findIndex(a=>a.id==item.id)
		})
	}


	$scope.initialize();

	$scope.reset=function (){
		$scope.form={

		}
	}

	$scope.showDetail=function (item){
		item.time= new Date("1970-01-01 "+item.time);
		$scope.form=angular.copy(item);
	}
	$scope.showDetail1=function (item){
		item.time= new Date("1970-01-01 "+item.time);
		$scope.form1=angular.copy(item);
	}
	$scope.showDetail2=function (item){
		item.time= new Date("1970-01-01 "+item.time);
		$scope.form2=angular.copy(item);
	}
	$scope.showDetail3=function (item){
		item.time= new Date("1970-01-01 "+item.time);
		$scope.form3=angular.copy(item);
	}
	$scope.showDetail5=function (item){
		item.time= new Date("1970-01-01 "+item.time);
		$scope.form5=angular.copy(item)
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
		get setPage(){
			return this.first();
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

	$scope.pager1 = {
		page: 0,
		size: 5,
		get items1(){
			var start = this.page * this.size;
			return $scope.items1.slice(start,start + this.size);
		},
		get count(){
			return Math.ceil(1.0 *$scope.items1.length / this.size)
		},

		first(){
			this.page = 0;
		},
		get setPage(){
			return this.first();
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

	$scope.pager2 = {
		page: 0,
		size: 5,
		get items2(){
			var start = this.page * this.size;
			return $scope.items2.slice(start,start + this.size);
		},
		get count(){
			return Math.ceil(1.0 *$scope.items2.length / this.size)
		},

		first(){
			this.page = 0;
		},
		get setPage(){
			return this.first();
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

	$scope.countDowClock=function (){

	}

	$scope.index_of=function(time){
		return time;
	}

	$scope.counter = 0;
	$scope.targetDate1=function (time){
			var time="01:50:55";
		var objProps = time.split(':');
		var myObj = {};
		myObj.hour = objProps[0];
		myObj.minutes = objProps[1];
		myObj.second = objProps[2];
		return new Date().getTime()+(1000*myObj.second*60*myObj.hour);
	}
	var targetDate=$scope.targetDate1();
	$scope.day=0;
	$scope.hour=0;
	$scope.minutes=0;
	$scope.second=0;
	$scope.demo=0;
	$scope.onTimeout = function(){
		$scope.cunrent_date=new Date().getTime();
		$scope.distance=targetDate-$scope.cunrent_date;
		$scope.day=Math.floor($scope.distance/(1000*60*60*24));
		$scope.hour=Math.floor(($scope.distance%(1000*60*60*24))/(1000*60*60));
		$scope.minutes=Math.floor(($scope.distance%(1000*60*60))/(1000*60));
		$scope.second=Math.floor(($scope.distance%(1000*60))/1000);
		$scope.demo=$scope.day+":"+$scope.hour+":"+$scope.minutes+":"+$scope.second;
		$scope.counter++;
		mytimeout = $timeout($scope.onTimeout,1000);
	}
	var mytimeout = $timeout($scope.onTimeout,1000);

	$scope.stop = function(){
		$timeout.cancel(mytimeout);
	}

	$scope.mySplit = function(string, nb) {
		var array = string.split(':');
		return array[nb];
	}


// 	var string = "Name1;Email1;ID1~Name2;Email2;ID2";
// // Initial split in entries
// 	var splitStrings = string.split('~');
// 	var objects = [];
// 	for(var i = 0; i < splitStrings.length; i++) {
// 		// split into properties
// 		var objProps = splitStrings[i].split(';');
// 		var myObj = {};
// 		myObj.name = objProps[0];
// 		myObj.mail = objProps[1];
// 		myObj.id = objProps[2];
// 		objects.push(myObj);
// 	}


	$scope.formCPM={
		voting: null,
		CusId: null,
		voucherId:null,
		totalPrice:null
	}

	$scope.voucherByCus = [];
	$scope.voucherByCustomer= function (id){
		$http.get(`/rest/voucherdetailByCustomer/${id}`).then(resp=>{
			$scope.voucherByCus = [];
			$scope.formCPM={};
			$scope.voucherByCus = resp.data;
			$scope.formCPM.CusId = id;
		})
	}

	var total = 0;
	$scope.pay={
		get totalPrice(){
			if($scope.formCPM.voucherId == null ){
				total = $scope.form1.totalPrice;
				// console.log('voucher: null');
			}else{
				for(var i =0; i < $scope.voucherByCus.length; i++){
					if($scope.formCPM.voucherId == $scope.voucherByCus[i].id){
						if(total > $scope.voucherByCus[i].condition){
							total = $scope.form1.totalPrice- $scope.voucherByCus[i].price
						}else{
							total = $scope.form1.totalPrice;
							alert("Không áp dụng được voucher vì tiền phải tối thiểu "+ $scope.voucherByCus[i].condition)
							// break;
						}
					}
				}
			}
			return total;
		},

		purchase() {
			alert($scope.vou)
			// var item = angular.copy($scope.formCPM);
			// item.totalPrice = total
			// $http.post(`/rest/bookingCus`, bookings).then(resp => {
			// 	alert("Thanh toan thành công!");
			// 	$scope.formCPM.clear();
			// 	location.href = "/booking";
			// }).catch(error => {
			// 	alert("Thanh toan thất bại!")
			// 	console.log(error);
			// })
		}
	}
	$scope.serviceByBooking= {
		listSer: [],
		getSerDetail(id) {
			$http.get(`/rest/bookingdetailByIdBooking/${id}`).then(resp => {
				this.listSer=[];
				this.listSer.push(resp.data);
				console.log(this.listSer[0])
			})
		}
	}
})