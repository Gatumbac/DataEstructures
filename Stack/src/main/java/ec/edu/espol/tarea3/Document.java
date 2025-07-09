/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tarea3;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 *
 * @author grupo1
 */
public class Document {
    private String content;
    Deque<String> versions;
    Deque<String> registeredVersions;
    
    public Document(){
        this.content = " '' |";
        this.versions = new ArrayDeque<>();
        this.registeredVersions = new ArrayDeque<>();
    }
    
    public String getContent(){
        return content;
    }
    
    public void addContent(String str){
        saveVersion(content);
        registeredVersions.clear();
        content += " " + str; 
    }
 
    
    private void saveVersion(String newContent){
        versions.push(newContent); 
    }
    
    public void rollBack(){
        if (versions.isEmpty()) return;
        
        String lastVersion = versions.pop();
        registeredVersions.push(this.content);
        this.content = lastVersion;
    }
    
    public void nextVersion(){
        if (registeredVersions.isEmpty()) return;
        
        String next = registeredVersions.pop();
        versions.push(this.content);
        this.content = next;
    }
    
    @Override
    public String toString(){
        return "\n" + content;
    }
    
    public void showHistorial(){
        System.out.println("\n-- Historial de versiones anteriores (versions) --");
        for (String version : versions){
            System.out.println(version);
        }
        System.out.println("\n-- Historial de versiones siguientes (registeredVersions) --");
        for (String version : registeredVersions){
            System.out.println(version);
        }
    }
    
}
