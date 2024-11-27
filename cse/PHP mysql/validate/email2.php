<?php
$reg = '/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/';
$email= $_POST["email"];
if(preg_match($reg, $email))
{
echo "Valid Email ID";
}
60
else
{
echo "Invalid Email ID";
}
?>
