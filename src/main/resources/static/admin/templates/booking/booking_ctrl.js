app.controller("booking-ctrl",function($scope,$http,$timeout,$q){
	$scope.items=[];
	$scope.items1=[];
	$scope.items2=[];
	$scope.itemsCOM=[];
	$scope.item3=[];
	$scope.form={};
	$scope.form1={};
	$scope.form2={};
	$scope.form3={};
	$scope.form5={};
	$scope.formCOM={};
	$scope.sizePage = [5,10,15,20];
	$scope.stylist=[];
	$scope.listCutting=[];
	$scope.employee1=[];
	$scope.bookingWaiting=[];
	$scope.itemConfirm=[];

	var toprice;
	$scope.lichlamviec=[];
	$scope.disctinctDate=[];
	$scope.initialize=function (){
		//load booking
		$http.get("/rest/booking/WFC").then(resp=>{
			$scope.items=resp.data;
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate);
			})
		})

		$http.get("/rest/booking/COM").then(resp=>{
			$scope.itemsCOM=resp.data;
			$scope.itemsCOM.forEach(item => {
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

		$http.get("/rest/booking").then(resp=>{
			$scope.item3=resp.data;
			$scope.item3.forEach(item => {
				item.createDate = new Date(item.createDate)
			})
		})

		$http.get("/rest/booking/employee").then(resp=>{
			$scope.employee1=resp.data;
		})

		$http.get("/rest/booking/checkedService").then(resp=>{
			$scope.db=resp.data;
			$scope.servicesChecked=$scope.db.services;
		})

		$http.get("/rest/booking/EmployeeConfirm").then(resp=>{
			$scope.itemConfirm=resp.data;
		})

		//getDataStylist
		$http.get("/rest/booking/stylist").then(resp=>{
			$scope.stylist = resp.data;
		})

		$http.get("/rest/booking/bookingIAT").then(resp=>{
			$scope.listCutting = resp.data;
		})
		
		
		
		$http.get("/rest/Workassign/disctinctDate").then(resp => {
            $scope.disctinctDate = resp.data;
			
        });
		
        
	}
	
	$scope.getDataStylistWorkassign = function(item){
		for(var i = 0; i < $scope.disctinctDate.length; i++){
			$http.get(`/rest/Workassign/stylist/${item.date}`).then(response => {
	            $scope.lichlamviec = response.data;
	        });
		}
	}

	$scope.showBookingWating=function (bookingId,serviceId){
		$scope.a=$scope.db.bookingDetails.findIndex(a=>a.booking.id==bookingId&&a.service.id==serviceId)
		return $scope.a;
	}

	//namnt stylist
	$scope.getDataBookingWaitting = function (stylistId){
		$http.get(`/rest/booking/bookingWaiting/${stylistId}`).then(resp=>{
			$scope.bookingWaiting = resp.data;
		})
	}
	$scope.customerInfoIAT = [];
	$scope.showInfoCustomerIAT =  function() {
		for (var i = 0; i < $scope.stylist.length; i++) {
			for (var j = 0; j < $scope.listCutting.length; j++) {
				if ($scope.stylist[i].id == $scope.listCutting[j].employee1.id) {
					$scope.customerInfoIAT[i] = $scope.listCutting[j];
				}
			}
		}		
	}	

	$scope.setBookingCutting = function (booking){
		$http.get(`/rest/booking/stylist/cutting/${booking.employee1.id}`).then(resp=>{

			if(resp.data == ''){
				booking.statusbooking.id = 'IAT';
				$http.put(`/rest/booking/setWorkForStylist/${booking.id}`,booking).then(resp => {
					var index = $scope.bookingWaiting.findIndex(p => p.id == booking.id);
					$scope.bookingWaiting[index] = booking;
					alert("Thêm công việc thành công cho "+ booking.employee1.fullName  +"!");
					$("#closeStylistModal").click();
					$scope.initialize();
				}).catch(error => {
					alert("Lỗi thêm công việc!");
					console.log("Error",error);
				});
			}else{
				alert("Stylist " + resp.data.employee1.fullName + " đang bận!")
			}
		});

	}
	
	$scope.tickDoneIAT = function(booking){
		if(booking == null || booking.customer == null){
			alert("Stylist đang không làm việc!!!")
		}else{
			if(confirm("Bạn có muốn hoàn thành công việc cho stylist "+ booking.employee1.fullName +" không?")){
				booking.statusbooking.id = 'WFP';
				$http.put(`/rest/booking/setWorkForStylist/${booking.id}`,booking).then(resp => {
					var index = $scope.bookingWaiting.findIndex(p => p.id == booking.id);
					var iCus = $scope.customerInfoIAT.findIndex(c => c == booking);
					$scope.bookingWaiting[index] = booking;
					$scope.customerInfoIAT[iCus].customer = null;
					alert("Kết thúc công việc thành công cho "+ booking.employee1.fullName  +"!");
					$scope.initialize();
				}).catch(error => {
					alert("Lỗi kết thúc công việc!");
					console.log("Error",error);
				});
			}
		}
		
		
	}

	$scope.initialize();

	$scope.reset=function (){
		$scope.form={

		}
	}

	$scope.showDetail=function (item){
		$scope.cart.clear();
		$scope.initialize();
		item.timeBooking= new Date("1970-01-01 "+item.timeBooking);
		$scope.form=angular.copy(item);
		$http.get(`/rest/bookingDetailsByBookingID/${item.id}`).then(resp=>{
			for (var i=0;i<resp.data.length;i++){
				$scope.cart.add(resp.data[i].id)
			}
		});
	}

	$scope.showDetailCOM=function (item){
		$scope.cart.clear();
		$scope.initialize();
		item.timeBooking= new Date("1970-01-01 "+item.timeBooking);
		$scope.formCOM=angular.copy(item);
		$http.get(`/rest/bookingDetailsByBookingID/${item.id}`).then(resp=>{
			for (var i=0;i<resp.data.length;i++){
				$scope.cart.add(resp.data[i].id)
			}
		});
	}

	$scope.showDetail1=function (item){
		$scope.initialize();
		item.timeBooking= new Date("1970-01-01 "+item.timeBooking);
		$scope.form1=angular.copy(item);
	}

	$scope.cccccc=[];
	$scope.showDetail2=function (item){
		$scope.cart.clear();
		$scope.initialize();
		item.timeBooking= new Date("1970-01-01 "+item.timeBooking);
		$scope.form2=angular.copy(item);
		$http.get(`/rest/bookingDetailsByBookingID/${item.id}`).then(resp=>{
			for (var i=0;i<resp.data.length;i++){
				$scope.cart.add(resp.data[i].id)
			}
		});
	}
	$scope.showDetail3=function (item){
		$scope.cart.clear();
		$scope.initialize();
		if (item !=null){
			item.timeBooking=new Date("1970-01-01 "+item.timeBooking);
			item.createDate=new Date(item.createDate);
			$scope.form3=angular.copy(item);
			$http.get(`/rest/bookingDetailsByBookingID/${item.id}`).then(resp=>{
				for (var i=0;i<resp.data.length;i++){
					$scope.cart.add(resp.data[i].id)
				}
			});
		}else{
			$scope.form3=null;
		}
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


	$scope.pagerCOM = {
		page: 0,
		size: 5,
		get itemsCOM(){
			var start = this.page * this.size;
			return $scope.itemsCOM.slice(start,start + this.size);
		},
		get count(){
			return Math.ceil(1.0 *$scope.itemsCOM.length / this.size)
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

//Hainv start
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
	$scope.voucherPay={}
	var voucherIdPay = null;
	$scope.pay={
		//Lay voucherId
		add(voucher){
			if (voucherIdPay == voucher.id) {
				voucherIdPay = null;
				$scope.totalPricebyVoucher.total = $scope.form1.totalPrice;				
			} else {
				voucherIdPay = voucher.id;
				console.log(voucherIdPay)
			}
		},
		purchase() {
			var item = angular.copy($scope.formCPM);

			var item2=angular.copy(item);

			if($scope.formCPM.voting==null){
				item2.voting = 2;
			}else {
				item2.voting=$scope.formCPM.voting;
			}
			item2.totalPrice = $scope.totalPricebyVoucher.total;
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


	$scope.listSer= []
	$scope.serviceByBooking= {
		getSerDetail(id) {
			$http.get(`/rest/bookingdetailByIdBooking/${id}`).then(resp => {
				$scope.listSer=[];
				$scope.listSer=resp.data;console.log($scope.listSer)
			})
			$scope.totalPricebyVoucher.total=$scope.form1.totalPrice
		}
	}

//total Price Thanh toan
	$scope.tenbuadi = '';
	$scope.totalPricebyVoucher={
		total:$scope.form1.totalPrice,
		totalPrice1(){
			console.log(this.total)
			this.total = $scope.form1.totalPrice;
			if(voucherIdPay == null ){
				this.total = $scope.form1.totalPrice;
			}else{
				$http.get(`/rest/voucher/${voucherIdPay}`).then(resp=>{
					$scope.voucherPay=resp.data;
					if(this.total  > resp.data.condition){
						this.total = $scope.form1.totalPrice - resp.data.price;
						$scope.tenbuadi = voucherIdPay;
						alert("Áp dụng voucher thành công!");
						$("#closeVoucherModal").click();
					} else {
						// console.log("Khong ap dung")
						alert("Không áp dụng được voucher vì tiền phải tối thiểu " + resp.data.condition);
						this.total = $scope.form1.totalPrice;

					}
					
					
					console.log(resp.data)
				})
			}
		}
	}

//Hainv end



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


	//form lưu thôg tin từ ng dùng nhập vào UI
	$scope.form2 = {
		email: null,
		fullName: null,
		phone: null,
		createDate: new Date(),
		note: null,
		stylistId: null,
		totalPrice: null,
		totalTime: null,
		listSer: [],
	};


	//thực hiện sửa lịch
	$scope.booking = {
		purchase() {
			var bookings = angular.copy($scope.form2);
			const value1 = moment($scope.form2.time).format('DD/MM/yyyy HH:mm:ss');
			bookings.time=value1;
			const value = moment($scope.form2.createDate).format('YYYY-MM-DD');
			if (toprice > 0) {
				bookings.totalTime = totime;
				bookings.totalPrice = toprice;
				bookings.createDate = value;
				bookings.listSer = $scope.cart.items;
				bookings.employee1=$scope.form2.employee1;

			} else {
				bookings.totalTime = 0;
				bookings.totalPrice = 0;
			}
			if (bookings.customer.fullName == null || bookings.customer.email == null
				|| bookings.createDate == null || bookings.customer.phone == null
				|| bookings.createDate == undefined || bookings.totalPrice==0||bookings.time=="Invalid date") {
				console.log($scope.form2)
				console.log($scope.cart.items)
				alert("Vui lòng nhập thông tin đầy đủ")

			} else {
				//checkBooking UCF by phone
				alert(bookings.time)
				$http.get(`/rest/checkBooking/${bookings.phone}`).then(resp => {
					$scope.bookingUCF = {}
					$scope.bookingUCF= resp.data;
					console.log( $scope.bookingUCF)
				})
				//add data => BE
					$http.post("/rest/booking/updateToWFC", bookings).then(resp => {
						alert("Xác nhận thành công !");
						$scope.cart.clear();
						$scope.initialize();
						$("#closeModelUCF").click();
					}).catch(error => {
						alert("Cập nhật thất bại!")
						// $scope.form.data = null;
						console.log(error);
					})
			}
		},
		updateWFC() {
			var bookings = angular.copy($scope.form);
			const value1 = moment($scope.form.time).format('DD/MM/yyyy HH:mm:ss');
			bookings.time=value1;
			const value = moment($scope.form.createDate).format('YYYY-MM-DD');
			if (toprice > 0) {
				bookings.totalTime = totime;
				bookings.totalPrice = toprice;
				bookings.createDate = value;
				bookings.listSer = $scope.cart.items;
				bookings.employee1=$scope.form.employee1;

			} else {
				bookings.totalTime = 0;
				bookings.totalPrice = 0;
			}
			if (bookings.customer.fullName == null || bookings.customer.email == null
				|| bookings.createDate == null || bookings.customer.phone == null
				|| bookings.createDate == undefined || bookings.totalPrice==0||bookings.time=="Invalid date") {
				console.log($scope.form)
				console.log($scope.cart.items)
				alert("Vui lòng nhập thông tin đầy đủ")

			} else {
				//checkBooking UCF by phone
				$http.get(`/rest/checkBooking/${bookings.phone}`).then(resp => {
					$scope.bookingUCF = {}
					$scope.bookingUCF= resp.data;
					console.log( $scope.bookingUCF)
				})
				//add data => BE
				$http.post("/rest/booking/updateWFC", bookings).then(resp => {
					alert("Cập nhật thành công !");
					$scope.cart.clear();
					$scope.initialize();
					$("#closeModelWFC").click();
				}).catch(error => {
					alert("Cập nhật thất bại!")
					// $scope.form.data = null;
					console.log(error);
				})
			}
		},
		capNhatDangCat() {
			if ($scope.form3!=null){
				var bookings = angular.copy($scope.form3);
				const value1 = moment($scope.form3.time).format('DD/MM/yyyy HH:mm:ss');
				bookings.time=value1;
				const value = moment($scope.form3.createDate).format('YYYY-MM-DD');
				if (toprice > 0) {
					bookings.totalTime = totime;
					bookings.totalPrice = toprice;
					bookings.createDate = value;
					bookings.listSer = $scope.cart.items;
					bookings.employee1=$scope.form3.employee1;
				} else {
					bookings.totalTime = 0;
					bookings.totalPrice = 0;
				}
				if (bookings.customer.fullName == null || bookings.customer.email == null
					|| bookings.createDate == null || bookings.customer.phone == null
					|| bookings.createDate == undefined || bookings.totalPrice==0||bookings.time=="Invalid date") {
					alert("Vui lòng nhập thông tin đầy đủ")

				}else{
					//checkBooking UCF by phone
					$http.get(`/rest/checkBooking/${bookings.phone}`).then(resp => {
						$scope.bookingUCF = {}
						$scope.bookingUCF= resp.data;
						console.log( $scope.bookingUCF)
					})
					//add data => BE
					$http.post("/rest/booking/updateWFC", bookings).then(resp => {
						alert("Lưu thành công !");
						$scope.cart.clear();
						$scope.initialize();
						$("#closeModalIAT").click();
					}).catch(error => {
						alert("Cập nhật thất bại!")
						// $scope.form.data = null;
						console.log(error);
					})
				}
			}else {
				alert("Không có dữ liệu để chỉnh sửa!")
			}
		}
	}

	$scope.updateCAN=function (item){
		var item1=angular.copy(item);
		if (confirm("Bạn có muốn huỷ lịch chờ này không?")){
			$http.put(`/rest/booking/updateToCan/${item1.id}`,item1).then(resp=>{
				var index = $scope.items2.findIndex(a => a.id == item1.id);
				$scope.items2[index] = item;
				alert("Huỷ thành công !")
				$scope.initialize();
			})
		}
	}
	
	
})
