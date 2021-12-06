app = angular.module("booking_Customer_app", [])
app.controller("booking_Customer_ctrl", function ($scope, $http) {

    var totime;
    var toprice;

//Lấy tất cả id của stylist => return: listSty: []
    $scope.Stylist = {
        listSty: [],
        addSty(id) {
            var item = this.listSty.find(item => item.id == id);
            var index = this.listSty.findIndex(item => item.id == id);
            if (item) {
                this.listSty.splice(index, 1);
            } else {
                this.listSty.push(id);
            }
            console.log(id)
        }
    }
    //lấy tất cả booking có status = IAT
    $scope. AllbookingIAT= [],
        $scope.initialize=function (){
            $http.get("/rest/bookingIAT").then(resp => {
                this.AllbookingIAT = resp.data;
            } )
        }
    $scope.initialize();

    //lấy totalTime theo từng stylist
    $scope.getAllSty = {
         a : [],
       get totalTimeStylist() {
           this.a=[]
            for(var i =0; i<$scope.Stylist.listSty.length;i++){
                    for(var j =0; j<$scope.AllbookingIAT.length;j++){
                        if($scope.Stylist.listSty[i] == $scope.AllbookingIAT[j].idSty){
                            this.a=$scope.AllbookingIAT[j].totalTime
                        }else{
                            this.a="00:00:00"
                        }
                    }
            }console.log(this.a)
           return this.a;
        }
    }

//form lưu thôg tin từ ng dùng nhập vào UI
    $scope.form = {
        email: null,
        fullName: null,
        phone: null,
        createDate: null,
        note: null,
        stylistId: null,
        totalPrice: null,
        totalTime: null,
        listSer: []
    };


    // $scope.form.fullName = "";
    // $scope.form.phone = "";
    // $scope.form.email = "";
    // $scope.form.listSer = "";
    // $scope.form.createDate = "";

    $scope.doSubmitForm = function (event) {
        // alert("OK: " + $scope.myForm.$submitted);
    }
// lấy id stylist khi click vào ảnh
    $scope.styId = function (id) {
        this.form.stylistId = id;
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
//Lay booking theo stylist
    $scope.bookingSty = []
    $scope.bookingByStylist = function () {
        $http.get("rest/bookingCusByStylist/").then(resp => {
            $scope.bookingSty.push(resp.data);
        })
    }
    //thực hiện đặt lịch
    $scope.booking = {
        purchase() {
            var bookings = angular.copy($scope.form);
            const value = moment($scope.form.createDate).format('YYYY-MM-DD');
            if (toprice > 0) {
                bookings.totalTime = totime;
                bookings.totalPrice = toprice;
                bookings.createDate = value;
                bookings.listSer = $scope.cart.items;
alert(toprice)
            } else {
                bookings.totalTime = null;
                bookings.totalPrice = null;
            }
            if (bookings.fullName == null || bookings.email == null || bookings.createDate == null
                || bookings.phone == null || bookings.createDate == undefined) {
                alert("Vui lòng nhập thông tin đầy đủ")
            } else {
                $http.post("/rest/bookingCus", bookings).then(resp => {
                    alert("Bạn đã đặt lich thành công! Hãy đợi nhân viên xác nhận trước khi đặt đơn mới. Thanks!");
                    $scope.cart.clear();
                    location.href = "/booking";
                }).catch(error => {
                    alert("Đặt lịch thất bại! Có vẻ bạn đã có lịch đang chờ nhân viên xác nhận, hãy liên hệ với chúng tôi để được hỗ trợ.")
                    // $scope.form.data = null;
                    console.log(error);
                })
            }


        }
    }


});