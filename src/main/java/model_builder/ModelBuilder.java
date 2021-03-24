package model_builder;


import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import gltf.GltfWriter;
import vecmath.Point3f;

public class ModelBuilder {
    private ArrayList<PNode> pnode = new ArrayList<>();
    private ArrayList<SNode> snode = new ArrayList<>();
    private ArrayList<Edge> arch = new ArrayList<>();

    public ModelBuilder() {
    }

    // Add an edge given two point in the space as vertices
    public void addEdge(float x1, float y1, float z1, float x2, float y2, float z2, Color c, String descr,String text){
        Point3f p1 = new Point3f(x1, y1, z1);
        Point3f p2 = new Point3f(x2, y2, z2);
        Edge edge = new Edge(p1, p2, c,descr,text);
        arch.add(edge);
    }

    // Add a spherical node given center, radius and the color
    public void addSNode(float x, float y, float z, double ray, Color c, String descr,String text){
        Point3f center = new Point3f(x, y, z);
        SNode sNode = new SNode(center, ray, c, descr,text);
        snode.add(sNode);
    }

    // Add a parallelepipedal node given the center, the width, height and depth
    public void addPNode(float x, float y, float z, float h, float w, float d, Color c, String descr,String text){
        Point3f center = new Point3f(x, y, z);
        PNode pNode = new PNode(center, h, d, w, c, descr,text);
        pnode.add(pNode);
    }

    // It loads an already existing edge
    public void loadEdge(float x1, float y1, float z1, float x2, float y2, float z2, Color c, String text){
        Point3f p1 = new Point3f(x1, y1, z1);
        Point3f p2 = new Point3f(x2, y2, z2);
        Edge edge = new Edge(p1, p2, c, text);
        arch.add(edge);
    }

    // It load an already existing spherical node
    public void loadSNode(float x, float y, float z, double ray, Color c, String text){
        Point3f center = new Point3f(x, y, z);
        SNode sNode = new SNode(center, ray, c,text);
        snode.add(sNode);
    }

    // It load an already existing parallelepipedal node
    public void loadPNode(float x, float y, float z, float h, float w, float d, Color c, String text){
        Point3f center = new Point3f(x, y, z);
        PNode pNode = new PNode(center, h, d, w, c, text);
        pnode.add(pNode);
    }

    // It builds the model
    public void buildModel(File file) throws Exception {
        GltfWriter gltfWriter = new GltfWriter();
        for(int i = 0; i< snode.size(); i++){
            snode.get(i).nodeGen(gltfWriter);
        }
        for(int j = 0; j<pnode.size();j++){
            pnode.get(j).nodeGen(gltfWriter);
        }
        for(int z = 0; z<arch.size();z++){
            arch.get(z).archGen(gltfWriter);
        }
        gltfWriter.writeGltf(file);
    }

    // Delete and edge
    public void deleteEdge(String elem) {
        for(int i = 0; i<arch.size();i++) {
            if (arch.get(i).description.equals(elem))
                arch.remove(i);
        }
    }

    // Delete a parallelepipedal node
    public void deletePNode(String elem) {
        for(int i = 0; i<pnode.size();i++) {
            if (pnode.get(i).description.equals(elem))
                pnode.remove(i);
        }
    }

    // Delete a spherical node
    public void deleteSNode(String elem) {
        for(int i = 0; i<snode.size();i++) {
            if (snode.get(i).description.equals(elem))
                snode.remove(i);
        }
    }

    // Delete the entire model
    public void deleteAll() {
        for (int i = 0; i < snode.size(); i++) {
            snode.remove(i);
        }
        for (int j = 0; j < pnode.size(); j++) {
            pnode.remove(j);
        }
        for (int z = 0; z < arch.size(); z++) {
            arch.remove(z);
        }
    }
}
