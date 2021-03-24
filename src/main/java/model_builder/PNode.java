package model_builder;


import de.javagl.jgltf.impl.v2.Material;
import gltf.GltfWriter;
import gltf.MeshBuilder;
import gltf.MeshVertex;
import vecmath.Point3f;

import java.awt.*;

public class PNode {
    private Point3f c;
    private float h;
    private float w;
    private float d;
    private Color color;
    public  String description;
    private String text;

    public PNode(Point3f center, float height, float depth, float width, Color color, String description, String text){
        this.c = center;
        this.d = height;
        this.w = width;
        this.h = depth;
        this.color = color;
        this.description = description;
        this.text = text;
    }

    public PNode(Point3f center, float height, float depth, float width, Color color, String text){
        this.c = center;
        this.d = height;
        this.w = width;
        this.h = depth;
        this.color = color;
        this.text = text;
    }



    public void nodeGen(GltfWriter gltf) throws Exception{
        MeshBuilder _meshBuilder = null;


        String path = "";
        boolean text = true;
        if(this.text.equals("blue"))
            path = "src/texture/blue.png";
        else if(this.text.equals("red"))
            path = "src/texture/red.png";
        else if(this.text.equals("green"))
            path = "src/texture/green.png";
        else if(this.text.equals("yellow"))
            path = "src/texture/yellow.png";
        else
            text = false;

        Material material; // = gltf.addTextureMaterial(path);


        _meshBuilder = new MeshBuilder("face-XY1");
        MeshVertex _vertexXY1_0 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y - this.d/2 , this.c.z + this.h/2));
        _vertexXY1_0.setColor(this.color);
        MeshVertex _vertexXY1_1 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y - this.d/2, this.c.z + this.h/2));
        _vertexXY1_1.setColor(this.color);
        MeshVertex _vertexXY1_2 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y + this.d/2 , this.c.z + this.h/2));
        _vertexXY1_2.setColor(this.color);
        MeshVertex _vertexXY1_3 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y + this.d/2 , this.c.z + this.h/2));
        _vertexXY1_3.setColor(this.color);
        _meshBuilder.addSquare(_vertexXY1_1, _vertexXY1_0, _vertexXY1_3, _vertexXY1_2);
        if(text) {
            material = gltf.addTextureMaterial(path);
            _meshBuilder.build(gltf, material);
        }
        else
            _meshBuilder.build(gltf, null);
        // face XY2
        _meshBuilder = new MeshBuilder("face-XY2");
        MeshVertex _vertexXY2_0 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y - this.d/2 , this.c.z - this.h/2));
        _vertexXY2_0.setColor(this.color);
        MeshVertex _vertexXY2_1 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y - this.d/2 , this.c.z - this.h/2));
        _vertexXY2_1.setColor(this.color);
        MeshVertex _vertexXY2_2 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y + this.d/2 , this.c.z - this.h/2));
        _vertexXY2_2.setColor(this.color);
        MeshVertex _vertexXY2_3 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y + this.d/2 , this.c.z - this.h/2));
        _vertexXY2_3.setColor(this.color);
        _meshBuilder.addSquare(_vertexXY2_1, _vertexXY2_0, _vertexXY2_3, _vertexXY2_2);
        if(text) {
            material = gltf.addTextureMaterial(path);
            _meshBuilder.build(gltf, material);
        }
        else
            _meshBuilder.build(gltf, null);

        // face YZ1
        _meshBuilder = new MeshBuilder("face-YZ1");
        MeshVertex _vertexYZ1_0 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y - this.d/2 , this.c.z - this.h/2));
        _vertexYZ1_0.setColor(this.color);
        MeshVertex _vertexYZ1_1 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y - this.d/2 , this.c.z + this.h/2));
        _vertexYZ1_1.setColor(this.color);
        MeshVertex _vertexYZ1_2 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y + this.d/2 , this.c.z - this.h/2));
        _vertexYZ1_2.setColor(this.color);
        MeshVertex _vertexYZ1_3 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y + this.d/2 , this.c.z + this.h/2));
        _vertexYZ1_3.setColor(this.color);
        _meshBuilder.addSquare(_vertexYZ1_1, _vertexYZ1_0, _vertexYZ1_3, _vertexYZ1_2);
        if(text) {
            material = gltf.addTextureMaterial(path);
            _meshBuilder.build(gltf, material);
        }
        else
            _meshBuilder.build(gltf, null);

        // face YZ2
        _meshBuilder = new MeshBuilder("face-YZ2");
        MeshVertex _vertexYZ2_0 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y - this.d/2 , this.c.z + this.h/2));
        _vertexYZ2_0.setColor(this.color);
        MeshVertex _vertexYZ2_1 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y - this.d/2 , this.c.z - this.h/2));
        _vertexYZ2_1.setColor(this.color);
        MeshVertex _vertexYZ2_2 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y + this.d/2 , this.c.z + this.h/2));
        _vertexYZ2_2.setColor(this.color);
        MeshVertex _vertexYZ2_3 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y + this.d/2 , this.c.z - this.h/2));
        _vertexYZ2_3.setColor(this.color);
        _meshBuilder.addSquare(_vertexYZ2_1, _vertexYZ2_0, _vertexYZ2_3, _vertexYZ2_2);
        if(text) {
            material = gltf.addTextureMaterial(path);
            _meshBuilder.build(gltf, material);
        }
        else
            _meshBuilder.build(gltf, null);

        // face top
        _meshBuilder = new MeshBuilder("face-Top");
        MeshVertex _vertexTop_0 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y + this.d/2 , this.c.z + this.h/2));
        _vertexTop_0.setColor(this.color);
        MeshVertex _vertexTop_1 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y + this.d/2 , this.c.z + this.h/2));
        _vertexTop_1.setColor(this.color);
        MeshVertex _vertexTop_2 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y + this.d/2 , this.c.z - this.h/2));
        _vertexTop_2.setColor(this.color);
        MeshVertex _vertexTop_3 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y + this.d/2 , this.c.z - this.h/2));
        _vertexTop_3.setColor(this.color);
        _meshBuilder.addSquare(_vertexTop_1, _vertexTop_0, _vertexTop_3, _vertexTop_2);
        if(text) {
            material = gltf.addTextureMaterial(path);
            _meshBuilder.build(gltf, material);
        }
        else
            _meshBuilder.build(gltf, null);

        // face bottom
        _meshBuilder = new MeshBuilder("face-Bottom");
        MeshVertex _vertexBottom_0 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y - this.d/2 , this.c.z + this.h/2));
        _vertexBottom_0.setColor(this.color);
        MeshVertex _vertexBottom_1 = _meshBuilder.newVertex(new Point3f(this.c.x - this.w/2, this.c.y - this.d/2 , this.c.z - this.h/2));
        _vertexBottom_1.setColor(this.color);
        MeshVertex _vertexBottom_2 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y - this.d/2 , this.c.z + this.h/2));
        _vertexBottom_2.setColor(this.color);
        MeshVertex _vertexBottom_3 = _meshBuilder.newVertex(new Point3f(this.c.x + this.w/2, this.c.y - this.d/2 , this.c.z - this.h/2));
        _vertexBottom_3.setColor(this.color);
        _meshBuilder.addSquare(_vertexBottom_1, _vertexBottom_0, _vertexBottom_3, _vertexBottom_2);
        if(text) {
            material = gltf.addTextureMaterial(path);
            _meshBuilder.build(gltf, material);
        }
        else
            _meshBuilder.build(gltf, null);
    }
}
