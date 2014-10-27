$(function() {
	
	var students = [
		["Grace", "Molly", "Hannah", "Emma", "Emily", "Allie", "Megan", "Miranda",
		 "Gladys", "Phebe", "Isabel", "Ally", "Amanda", "Bridget", "Maude", 
		 "Elsa", "Alex", "Fiona"],
		["Emily", "Cassie", "Casey", "Kate", "Madison", "Chloe", "Andrea",
		 "Jingmei", "Annie", "Isabella", "Anna", "Molly", "Laura", "Lindsey",
		 "Niki", "Gianna", "Mackenzie", "Gladys"]];

	var selectedStudents;
	var isSpinning = false;

	var loadStudents = function(day) {
		var list = $("#student_list");
		students[day].forEach(function(name) {			
			list.append($("<li></li>").append(name));
		});
		setHeights();
		$('#student_list li').on('click', function() {
			if(!isSpinning) {
				$(this).addClass('randomChoice');
			}
		});
	};

	var setHeights = function() {
		var studentElem = $('#student_list li');
		var length = studentElem.length % 2 == 1 ? studentElem.length + 1: studentElem.length;
		var height = ($(window).height() - length * 3) / (length / 2);
		studentElem.css({
			"height": height + "px",
			"line-height" : height + "px"
		});
	};

	var spinWheel = function() {
		if(!isSpinning) {
			selectedStudents = $('.randomChoice');
			if(selectedStudents.length > 0) {
				selectedStudents.fadeOut("slow").promise().done(function() {
					$(this).remove();
					singleSpin();
				});
			} else {
				singleSpin();
			}
		}
	};

	var singleSpin = function() {
		setHeights();
		var studentElem = $('#student_list li');
		isSpinning = true;
		switchStudent(studentElem, $(studentElem[0]), 50, 0);
	};

	var switchStudent = function(studentElem, prevElem, time, count) {
		if(count <= 100) {
			setTimeout(function() {
				var delay = getTime(count);
				var random = Math.floor(Math.random() * studentElem.length);
				var currentElem = $(studentElem[random]);
				prevElem.removeClass('randomChoice');
				currentElem.addClass('randomChoice');

				switchStudent(studentElem, currentElem, delay, count + 1);
			}, time)
		} else {
			isSpinning = false;
		}
	};

	var getTime = function(count) {
		var delay = 20;
		if(count >= 25  && count < 50)
			delay = 35;
		else if(count >=  50 && count < 75)
			delay = 75;
		else if(count >= 75 && count < 90)
			delay = 100;
		else if(count >= 90)
			delay = count * 3;
		return delay
	};

	$('.spin').on('click', spinWheel);

	var dayButtons = $('.day_button');
	var loaded = false;
	dayButtons.on('click', function() {
		if(!loaded) {
			loaded = true;
			loadStudents(dayButtons.index(this));
			dayButtons.fadeOut("slow", function() {
				$('#main_view').fadeIn("slow");
			});
		}
	});
});