app = angular.module("booking_Customer_app", [])
app.controller("booking_Customer_ctrl", function ($scope, $http) {

    $scope.getMinMaxTime = {
        today: new Date(),
        minDate: '',
        maxDate: '',

        FuncMinDate() {
            var input = document.getElementById("txtDate");
            var dd = this.today.getDate() + 1;
            var mm = this.today.getMonth() + 1;
            var yyyy = this.today.getFullYear();

            if (this.today.getHours() > 21) {
                dd = this.today.getDate() + 2;
            }

            if (dd > 31) {
                dd = this.today.getDate() - 30;
                mm = this.today.getMonth() + 2;
            } else {
                mm = this.today.getMonth() + 1;
            }

            if (mm < 10) {
                if (mm == 2) {
                    if (dd > 28) {
                        dd = this.today.getDate() - 27;
                        mm = this.today.getMonth() + 2;
                    }

                }
                mm = '0' + mm;
            }

            if (dd < 10) {
                dd = '0' + dd;
            }
            this.minDate = yyyy + '-' + mm + '-' + dd;
            input.setAttribute("min", this.minDate);
            return this.minDate;
        },

        FuncMaxDate() {
            var input = document.getElementById("txtDate");
            var mmMax = this.today.getMonth() + 2;
            var ddMax = this.today.getDate() - 1;
            var yyyy = this.today.getFullYear();

            if (mmMax > 12) {
                if (ddMax <= 23) {
                    mmMax = this.today.getMonth() + 1;
                    ddMax = this.today.getDate() + 7;
                    yyyy = this.today.getFullYear();
                } else {
                    ddMax = this.today.getDate() - 24;
                    mmMax = this.today.getMonth() - 10;
                    yyyy = this.today.getFullYear() + 1;
                }
            } else {
                if (ddMax <= 23) {
                    mmMax = this.today.getMonth() + 1;
                    ddMax = this.today.getDate() + 7;
                    yyyy = this.today.getFullYear();
                    if (mmMax == 2) {
                        ddMax = this.today.getDate() - 20;
                        mmMax = this.today.getMonth() + 2;
                    }
                } else {
                    ddMax = this.today.getDate() - 23;
                    mmMax = this.today.getMonth() + 2;
                    if (mmMax == 3) {
                        ddMax = this.today.getDate() - 21;
                    }
                }

            }
            if (mmMax < 10) {
                mmMax = '0' + mmMax;
            }
            if (ddMax < 10) {
                if (ddMax <= 0) {
                    ddMax = this.today.getDate();
                }
                ddMax = '0' + ddMax;
            }

            this.maxDate = yyyy + '-' + mmMax + '-' + ddMax;
            input.setAttribute("max", this.maxDate);
            console.log("minDate: " + this.minDate);
            console.log("maxDate: " + this.maxDate);
        }
    }

    $scope.getMinMaxTime.FuncMinDate();
    $scope.getMinMaxTime.FuncMaxDate();

    var totime;
    var toprice;

//form lưu thôg tin từ ng dùng nhập vào UI
    $scope.form = {
        email: null,
        fullName: null,
        phone: null,
        createDate: new Date($scope.getMinMaxTime.minDate),
        note: null,
        stylistId: null,
        totalPrice: null,
        timeBooking: null,
        listSer: [],
        listTime: []
    };

    // $scope.form.fullName = "";
    // $scope.form.phone = "";
    // $scope.form.email = "";
    // $scope.form.listSer = "";
    // $scope.form.createDate = "";

    $scope.doSubmitForm = function (event) {
        // alert("OK: " + $scope.myForm.$submitted);
    }

    $scope.shiftsByStylist="";
    $scope.timeBookingByShifts=[]
// lấy id stylist khi click vào ảnh
    $scope.styId = function (id) {
        this.form.stylistId = id;

        //lay shift
        $http.get("rest/bookingCusByStylist/").then(resp => {
            $scope.shiftsByStylist=resp.data;
        //lay time booking
            $http.get("rest/bookingCusByStylist/").then(resp => {
                $scope.timeBookingByShifts.push(resp.data);

            })
        })
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
                $scope.form.totalPrice == 0;
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


    //checkBooking UCF by Customer


    // $scope.checkBooking=function (){
    //     var phone = $scope.form.phone;
    //     $http.get(`rest/checkBooking/${phone}`).then(resp => {
    //         $scope.bookingUCF = {}
    //         $scope.bookingUCF= resp.data;
    //         // console.log( $scope.bookingUCF)
    //     })
    // }

//Lay booking theo stylist
    $scope.bookingSty = []
    $scope.bookingByStylist = function () {
        $http.get("rest/bookingCusByStylist/").then(resp => {
            $scope.bookingSty.push(resp.data);

        })
    }
    //thực hiện đặt lịch

    $scope.bookingUCF = {}
    $scope.booking = {
        purchase() {

            var bookings = angular.copy($scope.form);
            const value = moment($scope.form.createDate).format('YYYY-MM-DD');


            if (toprice > 0) {
                bookings.totalTime = totime;
                bookings.totalPrice = toprice;
                bookings.createDate = value;
                bookings.listSer = $scope.cart.items;

            } else {
                bookings.totalTime = 0;
                bookings.totalPrice = 0;
            }
            if (bookings.fullName == null || bookings.email == null
                || bookings.createDate == null || bookings.phone == null
                || bookings.createDate == undefined || $scope.cart.items.length == 0) {
                alert("Vui lòng nhập thông tin đầy đủ")

            } else {
                //checkBooking UCF by phone
                $http.get(`rest/checkBooking/${bookings.phone}`).then(resp => {
                    $scope.bookingUCF = {}
                    $scope.bookingUCF = resp.data;
                    console.log($scope.bookingUCF)

                    //add data => BE
                    if ($scope.bookingUCF == "") {
                        console.log("oke roi")
                        $http.post("/rest/bookingCus", bookings).then(resp => {
                            alert("Bạn đã đặt lich thành công! Hãy đợi nhân viên xác nhận trước khi đặt đơn mới. Thanks!");
                            $scope.cart.clear();
                            $("#closeModalBookingCustomer").click();
                            //location.href = "/booking";
                        }).catch(error => {
                            alert("Đặt lịch thất bại!")
                            // $scope.form.data = null;
                            console.log(error);
                        })
                    } else {
                        alert("Đặt lịch thất bại! Có vẻ bạn đã có lịch đang chờ nhân viên xác nhận, hãy liên hệ với chúng tôi để được hỗ trợ.")
                        // location.href = "/booking";
                    }
                })


            }
        }
    }


});