package model_builder;

import de.javagl.jgltf.impl.v2.Material;
import gltf.GltfWriter;
import gltf.MeshBuilder;
import gltf.MeshVertex;
import vecmath.Point3f;
import java.awt.*;

public class Edge {
        private Point3f p1;
        private Point3f p2;
        private Color color;
        public String description;
        private String text;

        public Edge(Point3f p1, Point3f p2, Color color, String description, String text){
            this.p1 = p1;
            this.p2 = p2;
            this.color = color;
            this.description = description;
            this.text = text;
        }

    public Edge(Point3f p1, Point3f p2, Color color, String text){
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
        this.text = text;
    }

        public void archGen(GltfWriter gltf)throws Exception{

            MeshBuilder _meshBuilder = new MeshBuilder("arch");

            // radius of the circle that constructs the helix
            final float circleRad = 0.5f;

            // number of levels of circles when building the grid
            final int circleSide = 10;

            final MeshVertex[][] _meshGrid = new MeshVertex[2][];

            _meshGrid[0] = _meshBuilder.addCircleVerticesXZ(this.p1,  circleRad, circleSide, this.color);
            _meshGrid[1] = _meshBuilder.addCircleVerticesXZ(this.p2,  circleRad, circleSide, this.color);

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


            // join the ends of the surface to create a tube
            _meshBuilder.addLathe(_meshGrid, text);
            Material material; //= gltf.addTextureMaterial(path);
            if(text) {
                material = gltf.addTextureMaterial(path);
                _meshBuilder.build(gltf, material);
            }
            else
                _meshBuilder.build(gltf, null);
        }
    }

