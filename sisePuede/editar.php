<?php

include_once("conexion.php");

class CRUDeditar{

public static function editar($id,$nombre,$descripcion,$precio,$cod_bodega){

$objeto= new Conexion();
$conectar = $objeto->conectar();

$sql="UPDATE productos SET nombre='$nombre',descripcion='$descripcion',precio='$precio',cod_bodega='$cod_bodega' WHERE codigo='$id'";

$resultado = $conectar->prepare($sql);
$resultado->execute();
$dato = $resultado->fetchAll(PDO::FETCH_ASSOC);
$conectar->commit();
echo(json_encode($dato));

}

}

?>