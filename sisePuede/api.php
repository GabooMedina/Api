<?php

include_once("conexion.php");
include_once("buscar.php");
include_once("guardar.php");
include_once("editar.php");
include_once("eliminar.php");
include_once("seleccionarTodo.php");

$opcion = $_SERVER["REQUEST_METHOD"];

switch ($opcion) {

   // case 'GET':
       // CRUDtodo::todo();
         //  break;

    case 'GET':
        
        $nombre =$_GET["nombre"];
        $direccon =$_GET["direccion"];
        CRUD::obtenerEstudiante($nombre,$direccon);
        break;

    case 'POST':
        
        CRUDguardar::guardarProducto();

        break;

    case 'PUT':
         $id=$_GET["codigo"];
         $nombre=$_GET["nombre"];
         $descripcion=$_GET["descripcion"];
         $precio=$_GET["precio"];
         $cod_bodega=$_GET["cod_bodega"];
         
         CRUDeditar::editar($id,$nombre,$descripcion,$precio,$cod_bodega);

            break;

    
    case 'DELETE':
        
         $codigo =$_GET["codigo"];
                CRUDelimnar::eliminar($codigo);
                break;
        

    default:
        # code...
        break;
}


?>