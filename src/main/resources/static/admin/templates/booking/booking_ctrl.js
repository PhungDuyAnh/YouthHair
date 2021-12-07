app.controller("booking-ctrl",function($scope,$http,$timeout,$q){
	$scope.items=[];
	$scope.items1=[];
	$scope.items2=[];
	$scope.form={};
	$scope.form1={};
	$scope.form2={};
	$scope.form3={};
	$scope.form5={};
	$scope.sizePage = [5,10,15,20];
	$scope.employee=[];
	$scope.employee1=[];
	$scope.itemWaiting=[];
	$scope.itemConfirm=[];
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

		$http.get("/rest/booking/checkedService").then(resp=>{
			$scope.db=resp.data;
		})

		$http.get("/rest/booking/EmployeeConfirm").then(resp=>{
			$scope.itemConfirm=resp.data;
		})

	}

	$scope.showBookingWating=function (bookingId,serviceId){
		$scope.a=$scope.db.bookingDetails.findIndex(a=>a.booking.id==bookingId&&a.service.id==serviceId)
		return $scope.a;
	}



	$scope.initialize();

	$scope.reset=function (){
		$scope.form={

		}
	}

	$scope.showDetail=function (item){
		$scope.initialize();
		item.time= new Date("1970-01-01 "+item.time);
		$scope.form=angular.copy(item);
	}
	$scope.showDetail1=function (item){
		$scope.initialize();
		item.time= new Date("1970-01-01 "+item.time);
		$scope.form1=angular.copy(item);
	}
	$scope.showDetail2=function (item){
		$scope.initialize();
		item.time= new Date("1970-01-01 "+item.time);
		$scope.form2=angular.copy(item);
	}
	$scope.showDetail3=function (item){
		$scope.initialize();
		item.time= new Date("1970-01-01 "+item.time);
		$scope.form3=angular.copy(item);
	}
	$scope.showDetail5=function (item){
		$scope.initialize();
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
		return new Date().getTime()+(1000*60*60*myObj.hour+1000*60*myObj.minutes+(1000*60-(1000*60-1000*myObj.second)));
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
		cusId: null,
		voucherId:null,
		totalPrice:null
	}
	$scope.formTT={
		voting: null,
		cusId: null,
		voucherId:null,
		totalPrice:null
	}

	$scope.votingId=function (id){
		$scope.formCPM.voting = id;
		console.log($scope.formCPM.voting)
	}
	$scope.voucherByCus = [];
	$scope.voucherCus={
		voucherByCustomer(id){
		$http.get(`/rest/voucherdetailByCustomer/${id}`).then(resp=>{
			$scope.voucherByCus.length=0;
			$scope.formCPM={};
			$scope.voucherByCus = resp.data;
			$scope.formCPM.cusId = id;
		})
	}
}



	$scope.a=function (){console.log("asd") ;return 1;}

//total Price Thanh toan
	$scope.total=0;
	$scope.pay={
		get totalPrice1(){

			if($scope.formCPM.voucherId == null ){
				this.total = $scope.form1.totalPrice;
			}else{
				for(var i =0; i < $scope.voucherByCus.length; i++){
					if($scope.formCPM.voucherId.id == $scope.voucherByCus[i].id){
						if(this.total  > $scope.voucherByCus[i].condition){
							this.total  = $scope.form1.totalPrice- $scope.voucherByCus[i].price
						}else{
							// console.log("Khong ap dung")
							console.log("Không áp dụng được voucher vì tiền phải tối thiểu "+ $scope.voucherByCus[i].condition)
							this.total  = $scope.form1.totalPrice;

						}
					}
				}console.log("else")
			}
			return this.total ;
		},

		purchase() {
			var item = angular.copy($scope.formCPM);

			var item2=angular.copy(item);

			if($scope.formCPM.voting==null){
				item2.voting = 2;
			}else {
				item2.voting=$scope.formCPM.voting;
			}
			item2.totalPrice = $scope.pay.totalPrice1;
			item2.cusId = $scope.formCPM.cusId

			if($scope.formCPM.voucherId==null){
				item2.voucherId = null;
			}else {
				item2.voucherId = $scope.formCPM.voucherId.id
			}

			console.log(item2);
			$http.post("/rest/payVoucherdetail", item2).then(resp => {
				alert("Thanh toan thành công!");
				$scope.formCPM={};
				location.reload();
			}).catch(error => {
				alert("Thanh toan thất bại!")
				console.log(error);
			})
		}
	}

	$scope.totalPriceIAT=function (){return $scope.pay.totalPrice1},
	$scope.listSer= []
	$scope.serviceByBooking= {
		getSerDetail(id) {
			$http.get(`/rest/bookingdetailByIdBooking/${id}`).then(resp => {
				$scope.listSer=[];
				$scope.listSer=resp.data;console.log($scope.listSer)
			})

		}
	}

	//Lấy list service người dùng chọn
	$scope.cart = {
		items: [],
		//Them service vao list

		add(id) {
			var item = this.items.find(item => item.id == id);
			var index = this.items.findIndex(item => item.id == id);
			if (item) {
				this.items.splice(index, 1);
			} else {
				$http.get(`/rest/services/${id}`).then(resp => {
					this.items.push(resp.data);
				})
			}
		},
		// Xóa sạch list
		clear() {
			this.items = [];
		},
		// Tông thành tiền các service trong list
		get amount() {
			return this.items
				.map(item => item.price)
				.reduce((total, price) => toprice = (total += price), 0,);

		},
//tổng time trong list
		get totalTime() {
			var convertDate1 = null;
			var totalHour = 0;
			var totalMinutes = 0;
			var totalSeconds = 0;
			for (var i = 0; i < $scope.cart.items.length; i++) {
				convertDate1 = new Date("1970-01-01 " + $scope.cart.items[i].time);
				totalHour += convertDate1.getHours();
				totalMinutes += convertDate1.getMinutes();
				totalSeconds += convertDate1.getSeconds();
			}
			if (totalSeconds > 59) {
				totalSeconds -= 60;
				totalMinutes += 1;
			} else if (totalMinutes > 59) {
				totalMinutes -= 60;
				totalHour += 1;
			}
			var convertTotal = String(totalHour + ":" + totalMinutes + ":" + totalSeconds);
			var newDateByTotal = new Date("1970-01-01 " + convertTotal)
			const value = moment(new Date(newDateByTotal)).format('HH:mm');
			var value1 = moment(new Date(newDateByTotal)).format('HH:mm:ss');
			totime = value1;
			return value.replace(":", " Giờ ");
		},
	}
})