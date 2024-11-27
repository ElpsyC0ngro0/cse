<?php
$n=$_POST['fname'];
$a=$_POST['Age'];
$con=mysqli_connect("localhost","root","","test");
$sql="INSERT INTO stu_info(stu_name,stu_age)values('$n','$a')";
$r=mysqli_query($con,$sql);
if($r)
{
echo "student details added";
}
else
{
echo "student details not added";
}
?>
