<html>
<head>
	<title>Add Trip</title>
	<style>
		body {
		  background-color: linen;
		}
		
		h1 {
		  color: maroon;
		}
		
		#d1 {
			color: grey;	
			margin:10px;
		}
		
		h2{
			color:maroon;
			margin:5px;
		}
		
		#desc {
			  width:400px;
			  height:100px;
			  
		}
		#c_btn{
			width:300px;
			height:40px;
		}
		input{
			
		}
	</style>
</head>
<body>		

	<form action="/input_feedback">
			<h2>Add Trip</h2>

			<div id="d1">
				<b>From :</b>
				<input type="text" name="from" autocomplete:="on">
			</div>
			<div id="d1" >
				<b>Destination :</b>
				<input type="text" name="destination" autocomplete:="on">
			</div>
			<div id="d1">
				<b>Maximal Capacity : </b>
				<input style ="width:45px" type="number" name="capacity" autocomplete:="on">
			</div>
			<div id="d1">
				<b>Trip Cost : </b>
				<input style ="width:60px;" type="number" name="cost" autocomplete:="on">
			</div>
			<div id="d1">
			
				<b>Transportmittel : </b>
				<input id="c" type="radio" value="car" name="tr_radio" autocomplete:="on" >
				 <label for="c">Car</label>
				  	
				<input id="b" type="radio" value="bus" name="tr_radio" autocomplete:="on"> 
				 <label for="b">Bus</label>
				 
				<input id="t" type="radio" value="transporter" name="tr_radio" autocomplete:="on">
				 <label for="t">Transporter</label>
				  	
			</div>
			<div id="d1">
				<b>Date:</b>
				<input type="date" name="date" autocomplete:="on">  
				<input type="time" name="time" autocomplete:="on">		
			</div>
			<div id="d1">
				<b>Description :</b>
				<input id="desc" type="text" name="description" >
			</div>
			
			<div id="d1">
				<input id="uid" type="hidden" name="uid" value=${(uid)!""} >
			</div>
			
			<div>
				<button id="c_btn" type="submit"><b>Create</b></button>
			</div>
			
		</div>
	</form>
		
		
</body>
</html>
