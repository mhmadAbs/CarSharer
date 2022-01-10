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
		#error{
			color:brown;
		}
		#valid{
			color:green;
		}
		input{
g			autocomplete:"on";
		}
	</style>
</head>
<body>		

	<form action="/input_feedback">
			<h2>Add Trip</h2>

			<div id="d1">
				<b>From :</b>
				<input type="text" name="from" value=${from} disabled="disabled" >
			</div>
			<div id="d1" >
				<b>Destination :</b>
				<input type="text" name="destination" value=${destination} disabled="disabled">
			</div>
			<div id="d1">
				<b>Maximal Capacity : </b>
				<input style ="width:45px" type="number" name="capacity" value=${capacity} disabled="disabled">
			</div>
			<div id="d1">
				<b>Trip Cost : </b>
				<input style ="width:60px;" type="number" name="cost" value=${cost} disabled="disabled" >
			</div>
			<div id="d1">
			
				<b>Transportmittel : </b>
				<input id="c" type="radio" value=${transportmittel} name="radios" checked disabled="disabled" >
				 <label for="c">${transportmittel}</label>
				  	
			</div>
			<div id="d1">
				<b>Date:</b>
				<input type="date" name="date" value=${date} disabled="disabled" >  
				<input type="time" name="time" value=${time} disabled="disabled" >		
			</div>
			<div id="d1">
				<b>Description :</b>
				<input id="desc" type="text" name="description"  value=${description} disabled="disabled" >
			</div>
			
			
			<div>
				<#list errors as error>
						<div id="error">
							<b>${error}</b>
						</div>
				</#list>
			</div>
			<div id="valid">
				<b>${(valid_input)! ""}</b>		
			</div>
			
			<div id="valid">
				<b>${(inserted)! ""}</b>		
			</div>
			
			
			
		</div>
	</form>
		
		
</body>
</html>
