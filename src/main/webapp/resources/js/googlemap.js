/**
 * This is conf script for google map 
 */


function init(){
	
	var mapOptions = {
			
		center: new google.maps.LatLng(54.3957338,18.5770686),
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		zoom: 16,
		
		panControl:false,
		zoomControl: true,
		zoomControlOptions: {
			style: google.maps.ZoomControlStyle.SMALL,
			position: google.maps.ControlPosition.TOP_RIGHT
		},
		
		mapTypeControl: true,
		mapTypeControlOptions: {
			style: google.maps.MapTypeControlStyle.DROPDOWN_MENU,
			position: google.maps.ControlPosition.TOP_LEFT
		},
		
		scaleControl: true,
		scaleControlOptions: {
			position: google.maps.ControlPosition.TOP_CENTER
		},
		streetViewControl: false,
		overviewMapControl:false
	};
	
	var vanueMap;
	vanueMap = new google.maps.Map(document.getElementById('map'), mapOptions);
}

function loadScript(){
	var script = document.createElement('script');
	script.src = 'http://maps.googleapis.com/maps/api/js?sensor=false&callback=initialize';
	document.body.appendChild(script);
}

window.onload = loadScript;