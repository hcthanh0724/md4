$(document).ready(function() {
    var icon = $(".navbar-toggler-icon");
    var navbar = $(".navbar");
    $(icon).on("click", function() {
        setInterval(function() {
            if ($(".navbar .navbar-collapse").hasClass("show")) {
                var position = navbar.offset();
                navbar.css("position", "absolute");
                navbar.css("top", position.top);
                $(window).on("scroll", function() {
                    if ($(document).scrollTop() < navbar.position().top) {
                        navbar.css("top", $(document).scrollTop());
                    }
                });
            } else {
                navbar.css("position", "fixed");
                navbar.css("top", 0);
            }
        }, 0);
    });
});