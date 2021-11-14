angular.module("admin_app", ["ngRoute"]).config(function($routeProvider){
	$routeProvider
	.when("/", {
		templateUrl:"/admin/templates/dashboard.html"
	})
	.when("/booking", {
		templateUrl:"/admin/templates/booking/index.html"
	})
	.when("/checkbooking", {
		templateUrl:"/admin/templates/booking/bookingcheck.html"
	})
	.when("/services", {
		templateUrl:"/admin/templates/service/index.html"
	})
	.when("/contacts", {
		templateUrl:"/admin/templates/contact/index.html"
	})
	.when("/customers", {
		templateUrl:"/admin/templates/customer/index.html"
	})
	.when("/employees", {
		templateUrl:"/admin/templates/employee/index.html"
	})
	.when("/vouchers", {
		templateUrl:"/admin/templates/voucher/index.html"
	})
	.when("/billpaid", {
		templateUrl:"/admin/templates/bill/index.html"
	})
	.otherwise({
		templateUrl:"/admin/templates/404.html"
	})
})
