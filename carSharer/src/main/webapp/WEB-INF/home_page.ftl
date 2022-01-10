<html>
<head>
	<title>Home Page</title>
	<style>
	
	#new_btn{
		width:390px;
		height:40px;
		color:green;
		margin:10px;
		font-weight:bold;
	}
	
	#items{
		border:3.5px dashed green;
		padding:15px;
		width:350px;
		margin:10px;
		box-sizing:content-box;
		
	}
	
	#image{
		text-align:center;
		padding:15px;
	}
	
	h1{
		color:green;
	}
	
	
	</style>
</head>
<body>
	<h1>CarSharer</h1>
	<div>
		<h2><b>My Bookings</b></h2>
			<#list reservations as res>
				<div id = "items">
					<div id="image">
						<a href = "/view_drive?tid=${res.getTripId()}&icon=${res.getTripIcon()}">
							<img src= ${res.getTripIcon()} alt="somthing went wrong while loading the icon" width="50px" >	
						</a>
					</div>
					<div style="color:grey"><b>Start</b>  : ${res.getTripStartAddress()}</div>
					<div style="color:grey"><b>End</b>    : ${res.getTripEndAddress()}</div>
					<div style="color:grey"><b>Status</b> : ${res.getTripStatus()}</div>
				</div>
			</#list>	
	</div>
	
	<div>
		<h2><b>Available Trips</b></h2>
		<#list open_trips as trip>
				<div id="items">
					<div id="image">
						<a href = "/view_drive?tid=${trip.getId()}&icon=${trip.getIcon()}">
							<img src= ${trip.getIcon()} alt="somthing went wrong while loading the icon" width="50px" >	
						</a>
					</div>
					<div style="color:grey"><b>Start</b>  : ${trip.getStartAddress()}</div>
					<div style="color:grey"><b>End</b>    : ${trip.getEndAddress()}</div>
					<div style="color:grey"><b>Status</b> : ${trip.getStatus()}</div>
				</div>
		</#list>
	</div>
	
	<div >
		<a href="/new_drive?uid=${uid}">
			<button id="new_btn" type="submit">
				<b>New Trip</b>
			</button>
		</a>
	</div>

</body>
</html>
