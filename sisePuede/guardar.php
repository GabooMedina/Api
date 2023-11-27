<?php

include_once("conexion.php");

class CRUDguardar{

public static function guardarProducto(){

$objeto= new Conexion();
$conectar=$objeto->conectar();

$codigo=$_POST["codigo"];
$nombre=$_POST["nombre"];
$descripcion=$_POST["descripcion"];
$precio=$_POST["precio"];
$cod_bodega=$_POST["cod_bodega"];

$sql="INSERT INTO productos(codigo,nombre,descripcion,precio,cod_bodega) VALUES('$codigo','$nombre','$descripcion',$precio,'$cod_bodega')";

$resultado = $conectar->prepare($sql);
$resultado->execute();
$dato = $resultado->fetchAll(PDO::FETCH_ASSOC);
$conectar->commit();
echo json_encode($dato);
}

}

?>