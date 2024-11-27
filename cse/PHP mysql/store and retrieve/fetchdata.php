<?php
$con=mysqli_connect("localhost","root","","info");
if(!$con){
die('connection error' .mysqli_connect_error());
}
else
{
echo 'success<br>';
}
$query="select * from stu_info";
$result=mysqli_query($con,$query);
print_r($result);
$numrow=mysqli_num_rows($result);
if($numrow>0)
{
//echo $numrow. 'record found';
//while($row=mysqli_fetch_assoc($result)){
echo '<table border=1>';
echo '<tr>';
echo '<th>stuname</th>';
echo '<th>age</th>';
echo '</tr>';
while($row=mysqli_fetch_assoc($result)){
echo '<tr>';
echo '<td>' . $row['stu_name'] . '</td>';
echo '<td>' . $row['age'] . '</td>';
echo '</tr>';
}
echo '</table>';
}
else{
echo 'record not found';
}
?>
