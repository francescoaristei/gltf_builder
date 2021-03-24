package model_builder;

import de.javagl.jgltf.impl.v2.Material;
import gltf.GltfWriter;
import gltf.MeshBuilder;
import gltf.MeshVertex;
import vecmath.Point3f;
import java.awt.*;

public class SNode {
    private Point3f center;
    private double r;
    private Color color;
    public String description;
    private String text;

    public SNode(Point3f center, double r, Color color,String description, String text){
        this.center = center;
        this.r = r;
        this.color = color;
        this.description = description;
        this.text = text;
    }

    public SNode(Point3f center, double r, Color color, String text){
        this.center = center;
        this.r = r;
        this.color = color;
        this.text = text;
    }


    public void nodeGen(GltfWriter gltf) throws Exception {

        MeshBuilder _meshBuilder = new MeshBuilder("SphNode");

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

        Material material;

        final int _sizesVertical = 48;

        // sides of each circle on the horizontal axis
        final int _sidesHorizontal = 1000;

        // radius of the circles used to construct the torus
        final double _circleRadius = this.r;

        // grid to hold mesh vertices
        final MeshVertex[][] _meshGrid = new MeshVertex[_sizesVertical][];

        for(int _rIdx = 0; _rIdx < _sizesVertical; _rIdx++) {
            // Rotate about an angle from 0 to -2pi.
            // If we rotate the other way then planes would render as inverted.
            final double _angle = MeshBuilder.interpFloat(_sizesVertical, -2*Math.PI, _rIdx) - Math.PI;

            // calculate points along a circle that rotates about the axis.
            final double _radius = _circleRadius*Math.cos(_angle);

            final double _yPos = _circleRadius*Math.sin(_angle)+ this.center.y;

            // position of the circle to draw.
            final Point3f _circlePos = new Point3f(this.center.x, (float)_yPos, this.center.z);

            // for each point on the first circle draw another circle perpendicular
            _meshGrid[_rIdx] = _meshBuilder.addCircleVerticesXZ(_circlePos,
                    (float)_radius, _sidesHorizontal, this.color);
        }

        // join all corners of the surface to create a closed manifold.
        _meshBuilder.addManifold(_meshGrid, false);

        // generate gltf buffers
        if(text) {
            material = gltf.addTextureMaterial(path);
            _meshBuilder.build(gltf, material);
        }
        else
            _meshBuilder.build(gltf, null);

    }
}
