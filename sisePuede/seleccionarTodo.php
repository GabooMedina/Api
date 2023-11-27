<?php

include_once("conexion.php");

class CRUDtodo{

public static function todo(){

$objeto = new Conexion();
$conectar = $objeto->conectar();

$sql="SELECT* FROM productos";

$resultado=$conectar->prepare($sql);
$resultado->execute();
$data = $resultado->fetchAll(PDO::FETCH_ASSOC);
echo(json_encode($data));
$conectar->commit();

}


}


?>