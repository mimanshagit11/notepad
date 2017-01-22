import java.io.*;
import java.awt.*;
import java.io.*;
import java.util.regex.*;
import java.awt.event.*;
class notepad extends WindowAdapter implements ActionListener 
{
boolean state = false;
ActionEvent e1,e2;
Button b8,b9,b10,cl;
int h = 0,g = 0,d = 0,x = 0;
String resul,name1 = "a",path,Final = "",name = "a",str2 = "",str3 = "",name4 = "a",path4;
Frame f,f1,f2,f3,f4; MenuBar mb; Menu m1,m2;
MenuItem nw,opn,sve,svea,ext,fd,fdr;
TextArea ta;
TextField tf,tf1,tf2;
int i = 1, j = 1;
public notepad()
{
f = new Frame();
f.setSize(400,400);
mb = new MenuBar();
m1 = new Menu("File");
m2 = new Menu("Edit");


 ta = new TextArea();
nw = new MenuItem("New");
opn = new MenuItem("Open");
sve = new MenuItem("Save");
svea = new MenuItem("Save As..");
ext = new MenuItem("Exit");
fd = new MenuItem("Find");
fdr  = new MenuItem("Find and Replace");
 cl = new Button("cld");
cl.addActionListener(this);
nw.addActionListener(this);
opn.addActionListener(this);
sve.addActionListener(this);
svea.addActionListener(this);
ext.addActionListener(this);
fd.addActionListener(this);
fdr.addActionListener(this);
m1.add(nw);
m1.add(opn);
m1.add(sve);
m1.add(svea);
m1.addSeparator();
m1.add(ext);
m2.add(fd);
m2.add(fdr);
mb.add(m1);mb.add(m2);
f.add(ta);
f.setMenuBar(mb);
f.setVisible(true);
f1 =  new Frame();
Panel p1 = new Panel();
Button b = new Button("Next");
Button b1 = new Button("Close");
b.addActionListener(this);
b1.addActionListener(this);
p1.add(b);
p1.add(b1);
f1.add(p1,"South");

f1.setSize(300,200);
Panel p  = new Panel(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints(); 
Label l = new Label("Find");
 tf = new TextField(15);
gbc.gridx = 0; gbc.gridy = 0;
gbc.anchor = GridBagConstraints.NORTHWEST;
gbc.fill = GridBagConstraints.HORIZONTAL;
p.add(l,gbc);
gbc.gridx = 0; gbc.gridy = 1;
gbc.anchor = GridBagConstraints.NORTHWEST;
p.add(tf,gbc);
f1.add(p);
f1.setVisible(false);


f2 =  new Frame();


f2.setSize(300,200);
Panel p2  = new Panel(new GridBagLayout());
GridBagConstraints gbc1 = new GridBagConstraints();
 
Label l1 = new Label("Find");

gbc1.gridx = 0; gbc1.gridy = 0;
gbc1.anchor = GridBagConstraints.NORTHWEST;
gbc1.fill = GridBagConstraints.HORIZONTAL;
p2.add(l1,gbc1);
 tf2 =  new TextField(15); 
gbc1.gridx = 0; gbc1.gridy = 1;
gbc1.anchor = GridBagConstraints.NORTHWEST;
p2.add(tf2,gbc1);

gbc1.gridx = 0; gbc1.gridy = 2;
Label l2 = new Label("Replace with");
p2.add(l2,gbc1);
gbc1.gridx = 0; gbc1.gridy = 3;
 tf1 = new TextField(15);
p2.add(tf1,gbc1);
f2.add(p2);
Panel p3 = new Panel();
Button b2 = new Button("Find Next");
Button b5 = new Button("Close");
Button b3 = new Button("Replace");
Button b4 = new Button("Replace All");
b5.addActionListener(this);  b2.addActionListener(this);  b3.addActionListener(this);  b4.addActionListener(this);
p3.add(b2);
p3.add(b3);
p3.add(b4);
p3.add(b5);
f2.add(p3,"South");
f2.setVisible(false);

 
 f3 = new Frame();
f3.setSize(250,150);
Panel p4 = new Panel(new GridBagLayout());
Label l3 = new Label("Cannot Find Word");
p4.add(l3);
f3.add(p4);
Panel p5 = new Panel(new GridBagLayout());
GridBagConstraints gbc2 = new GridBagConstraints();
gbc2.ipadx = 50;
Insets i = new Insets(2,4,6,8);
gbc2.insets = i; 
Button b6 = new Button("OK");
b6.addActionListener(this);
p5.add(b6,gbc2);
f3.add(p5,"South");
f3.setVisible(false);

 f4 = new Frame();
f4.setSize(300,200);
Label l4 = new Label("Do you want to save changes to your Document ?");
f4.add(l4);
 b8 = new Button("Save");
 b9 = new Button("Don't Save");
 b10 = new Button("Cancel");
Panel p6 = new Panel();
 p6.add(b8); p6.add(b9); p6.add(b10);
b8.addActionListener(this);
b9.addActionListener(this);
b10.addActionListener(this);
f4.add(p6,"South");
f4.setVisible(false);
f.addWindowListener(this);
f1.addWindowListener(this);
f2.addWindowListener(this);
f3.addWindowListener(this);
f4.addWindowListener(this);
}
public void actionPerformed(ActionEvent e)
{
String str = e.getActionCommand();
switch(str)
{

case "Open" : if(!(Final.equals(ta.getText())))
                             {f4.setVisible(true);
                               e1 = e; break;
                              }else{
                        FileDialog  a = new FileDialog(f,"Open",FileDialog.LOAD);
                           a.setVisible(true);
                               name4 = a.getFile();path4  = a.getDirectory();
                        
                       try{
                           File f1 = new File(path4,name4);
                                                          
                           if(f1.exists())
                           {
                            if(i == 1)
                                 { name1 = name4;
                                         i++;}
                            if(!(name1.equals(name4)))
                              { ta.setText("");
                                        }
                              String s1;
                             if(( s1 = ta.getText())!= null)
                                 {  ta.setText("");}
                       try{
                         FileInputStream fis = new FileInputStream(f1);
                         BufferedInputStream bis3 = new BufferedInputStream(fis);
                          int ch;
                       while((ch = bis3.read() )!= -1)
                            {char c = (char)ch;
                                 ta.appendText(c + "");
                               }
                                    j++;
                                   bis3.close();  
                              Final = ta.getText();
                                  }
                       catch(Exception e1)
                          {}
                          }
                              else
                           
                                  System.out.print("File Not Found");
                     
                          }catch(Exception e2){}
                          e1 = null;} 
                    try{          if(e2.getSource() == b9)if(name4!=null)
                     { } else
                      { Final = "";e2 = null;}}catch(Exception f1){}              
                        break;

case  "Save" : f4.setVisible(false);
                        try{if(j==1)
                        {FileDialog b  = new FileDialog(f,"Save",FileDialog.SAVE);
                           b.setVisible(true);
                          path = b.getDirectory(); name = b.getFile();
                         j++;}
                      if(name != null){
                       try{
                       
                        File f1 = new File(path,name);
                         FileOutputStream fos1 = new FileOutputStream(f1);
                       BufferedOutputStream bos1 = new BufferedOutputStream(fos1);
                           String s = ta.getText();
                     char arr[] = s.toCharArray();
                       for(int k = 0; k < arr.length;k++)
                       {   
                          bos1.write((int)s.charAt(k));}
                          bos1.close();
                            Final = ta.getText();                           }catch(Exception a){}}else {j = 1;e1 = null;d = 0;}
                       if(e1.getSource() == opn)
                           actionPerformed(e1);
                      
                       if(e1.getSource() == nw)
                          actionPerformed(e1);
                        
                         if(e1.getSource() == ext)
                               actionPerformed(e1); }catch(Exception e1){}
                        if(d == 1){
                          System.exit(0);}
                        
                                                   break;

case "New" :  if(!(Final.equals(ta.getText())))
                          {    f4.setVisible(true); e1 = e;
break;                         }else{
                        if(ta.getText() != null)
                          ta.setText("");
                         Final = ta.getText();
                        j = 1;
                             e1 = null;}
                         break;

case "Save As.." :  FileDialog b  = new FileDialog(f,"Save",FileDialog.SAVE);
                           b.setVisible(true);
                          path = b.getDirectory(); name = b.getFile();
                                            
                      if(name != null){
                       try{ 
                       
                        File f = new File(path,name);
                         FileOutputStream fos = new FileOutputStream(f);
                         BufferedOutputStream bos = new BufferedOutputStream(fos);
                           String s11 = ta.getText();
                        char arr1[] = s11.toCharArray();
                         for(int k = 0; k < arr1.length;k++)
                       {          bos.write((int)s11.charAt(k));}
                         Final = ta.getText();
                          bos.close();}
                           catch(Exception e2){}}
                           break;
case "Exit"  : if(!(Final.equals(ta.getText())))
                          {    f4.setVisible(true);
e1 = e;             break;                }else
                     {  e1 = null; System.exit(0);}
case "Find" :  f1.setVisible(true);
                        break;
case "Cancel" : f4.setVisible(false);
                             e1  = null; d = 0;
                           break;
case  "Don't Save" :     if(true)f4.setVisible(false);
                                 Final = ta.getText();
                           try{
                             if(e1.getSource() == opn)
                        {e2 = e;   actionPerformed(e1);}
                        
                       if(e1.getSource() == nw)
                          actionPerformed(e1);
                        
                         if(e1.getSource() == ext)
                               actionPerformed(e1);}catch(Exception e3){}
                        
                          if(d == 1){
                           System.exit(0);}
                      
                                 break;
case "Next" :try{
                        int l = 0,hi = 0;
                     String result1 = "a"; 
                       String stra1 = tf.getText(),s2 = ta.getText();
                 StringBuffer stra = new StringBuffer(tf.getText());
            for(int c = 0; c < stra.length() ; c++)
                 {if(stra.charAt(c) == '+' || stra.charAt(c) == '*' || stra.charAt(c) == '$' || stra.charAt(c) == '{' || stra.charAt(c) == '[' || stra.charAt(c) == '(' || stra.charAt(c) == ')' || stra.charAt(c) == '|' || stra.charAt(c) == '?' || stra.charAt(c) == '.' || stra.charAt(c) == '^') l++;}
            l = l + stra.length();
              try{    for(int c = 0; c <  l; c++)
                     {   if(stra.charAt(c) == '+' || stra.charAt(c) == '*' || stra.charAt(c) == '$' || stra.charAt(c) == '{' || stra.charAt(c) == '[' || stra.charAt(c) == '(' || stra.charAt(c) == ')' || stra.charAt(c) == '|' ||  stra.charAt(c) == '?' || stra.charAt(c) == '.' || stra.charAt(c) == '^')
                            {stra.insert(c,"\\");
                                hi = 1;}
                        
                        if(hi == 1)
                 {   l = stra.length(); c = c+ 1;}}
                         
                        System.out.print(stra);}catch(Exception s){}
                  String s1 = new String(stra);
                                         Pattern p5  = Pattern.compile("\r");
                       Matcher m5 = p5.matcher(s2);
                   
                     if(m5.find())
                    {
                         result1 = m5.replaceAll("");
                          }else result1 = s2;
                  if(!s1.equals(str2))
                    {  g = 0;}
                      Pattern p3 = Pattern.compile(s1);
                      Matcher m = p3.matcher(result1);
                    
                   str2 = s1;String str3 = ta.getSelectedText();
               System.out.print(str2);
                    if(x>1)
                      if(!(str3.equals(stra1)))
                          {g = ta.getCaretPosition();
                         System.out.print(g);   
                     for(int r = 0; r < g; r ++)
                      {  if(ta.getText().charAt(r) == '\r'){
                                   g--;}}
                               Pattern p11 = Pattern.compile(s1);
                              Matcher m11 = p11.matcher(result1);
                        if(!m11.find(g))
                         f3.setVisible(true);  
                        while(m11.find(g))
                       {if(m11.find(g)){
                         ta.select(m11.start(),m11.end());
                   f.toFront();  
                           break;
                          }  }}
                   else
                      if(!m.find(g))
                         f3.setVisible(true);
                      while(m.find(g))
                       {if(m.find(g)){
                         ta.select(m.start(),m.end());
                   f.toFront();  
                          g = m.end(); x = 2;
                   System.out.print(g);
                         break;}
                          
                             }
                       }catch(Exception y){}                              
                         break;                     
                 

case "Find and Replace" : f2.setVisible(true);
                                             break;
case "Replace" : try{
                            resul = "a";String  s3  = tf2.getText();
                       String s4 = tf1.getText();
                       String s5 = ta.getText();
                    if(s3.equals("") || s4.equals(""))
{
 System.out.print("required text");
}
else
{          String result3 = "",str4 = ta.getSelectedText();
                    if(x>1)
                      if(!(str4.equals(s3)))
                          {g = ta.getCaretPosition();
                        
                     for(int r = 0; r <= g; r ++)
                      {  if(ta.getText().charAt(r) == '\r'){
                                   g--;}}
                        Pattern p5  = Pattern.compile("\r");
                       Matcher m5 = p5.matcher(s5);
                   
                     if(m5.find())
                    {
                         result3 = m5.replaceAll("");
                          }else result3 = s5;
                               Pattern p14 = Pattern.compile(s3);
                              Matcher m14 = p14.matcher(result3);
                   
                        if(!m14.find(g))
                       {  f3.setVisible(true);  }  
                        
                       if(m14.find(g)){   
                         ta.replaceText(s4,m14.start(),m14.end());g = ta.getSelectionEnd();
                   for(int r = 0; r <= g; r ++)
                      {  if(ta.getText().charAt(r) == '\r'){
                                   g--;}}
                   
                  System.out.print(g);    
                    
                         s5  =ta.getText();
                     Pattern p8  = Pattern.compile("\r");
                       Matcher m8 = p8.matcher(s5);
                     if(m8.find())
                    {
                         resul = m8.replaceAll("");
                          }else resul = s5;
                      Pattern p9 = Pattern.compile(s3);
                      Matcher m9 = p9.matcher(resul);
                    if(m9.find(g))
                       {  
ta.select(m9.start(),m9.end());
                            f.toFront();}else
                       f3.setVisible(true);
               break;}  

  }
 
if(str4.equals(s3) || x==0){
                      Pattern p4  = Pattern.compile("\r");
                       Matcher m4 = p4.matcher(s5);
                     if(m4.find())
                    {
                         resul = m4.replaceAll("");
                          }else resul = s5;
                      Pattern p2 = Pattern.compile(s3);
                      Matcher m2 = p2.matcher(resul);
                      if(m2.find(g))
                       {
                          ta.replaceText(s4,m2.start(),m2.end());
                         g = ta.getSelectionEnd();
                      for(int r = 0; r <= g; r ++)
                      {  if(ta.getText().charAt(r) == '\r'){
                                   g--;}}
                      
                  System.out.print(g);
                      x = 2;
                   s5  =ta.getText();
                     Pattern p8  = Pattern.compile("\r");
                       Matcher m8 = p8.matcher(s5);
                     if(m8.find())
                    {
                         resul = m8.replaceAll("");
                          }else resul = s5;
                      Pattern p9 = Pattern.compile(s3);
                      Matcher m9 = p9.matcher(resul);
                    if(m9.find(g))
                       {  ta.select(m9.start(),m9.end());
                            f.toFront();}else
                         f3.setVisible(true);
               break;}
}                    
                          
                          f3.setVisible(true);}}catch(Exception e3){}
                                  break;

case "Replace All" : String s6  = tf2.getText();
                       String s7 = tf1.getText();
                       String s8 = ta.getText();
                          if(s6.equals("") || s7.equals("")){
                     System.out.print("required text");}else{
                      Pattern p = Pattern.compile(s6);
                      Matcher m1 = p.matcher(s8);
                      if(m1.find())
                       {
                            String result =  m1.replaceAll(s7);
                            ta.setText(result);
                          break;
                  }          f3.setVisible(true);}
                             break;
case "Find Next" :                      String result2 = "a";
                       String s10 = ta.getText(),s15 = tf2.getText();
                      int hii = 0,l = 0;
                             StringBuffer stra = new StringBuffer(tf2.getText());
            for(int c = 0; c < stra.length() ; c++)
                 {if(stra.charAt(c) == '+' || stra.charAt(c) == '*' || stra.charAt(c) == '$' || stra.charAt(c) == '{' || stra.charAt(c) == '[' || stra.charAt(c) == '(' || stra.charAt(c) == ')' || stra.charAt(c) == '|' || stra.charAt(c) == '?' || stra.charAt(c) == '.' || stra.charAt(c) == '^') l++;}
            l = l + stra.length();
              try{    for(int c = 0; c <  l; c++)
                     {   if(stra.charAt(c) == '+' || stra.charAt(c) == '*' || stra.charAt(c) == '$' || stra.charAt(c) == '{' || stra.charAt(c) == '[' || stra.charAt(c) == '(' || stra.charAt(c) == ')' || stra.charAt(c) == '|' ||  stra.charAt(c) == '?' || stra.charAt(c) == '.' || stra.charAt(c) == '^')
                            {stra.insert(c,"\\");
                                hii = 1;}
                        
                        if(hii == 1)
                 {   l = stra.length(); c = c+ 1;}}
                         
                        }catch(Exception s){}
                  String s9 = new String(stra);
                                         Pattern p6  = Pattern.compile("\r");
                       Matcher m6 = p6.matcher(s10);
                     if(m6.find())
                    {
                         result2 = m6.replaceAll("");
                          }else result2 =  s10;
                     if(!(s9.equals(str3)))
                      g = 0;
                    str3 = s9;String str4 = ta.getSelectedText();
                      Pattern p7 = Pattern.compile(s9);
                      Matcher m7 = p7.matcher(result2);
                        if(x>1)
                      if(!(str4.equals(s15)))
                          {g = ta.getCaretPosition();
                            
                       for(int v = 0; v <= g; v ++)
                      {  if(ta.getText().charAt(v) == '\r'){
                                   g--;}}
                               Pattern p12 = Pattern.compile(s9);
                              Matcher m12 = p12.matcher(ta.getText());
                        if(!m12.find(g))
                         f3.setVisible(true);  
                        while(m12.find(g))
                       {if(m12.find(g)){
                         ta.select(m12.start(),m12.end());
                   f.toFront();  
                           break;
                          }  }}
                   else
                      if(!m7.find(g))
                         f3.setVisible(true);
                      while(m7.find(g))
                       {if(m7.find(g)){
                         ta.select(m7.start(),m7.end());
                   f.toFront();  
                          g = m7.end(); x = 2;
                         break;}
                          
                             }
                     
                             
                       
                              
                         break;                     
                 

 
case "Close" :  f1.setVisible(false);
                            f2.setVisible(false);
                         g = 0;x =0;
                           break;
case "OK" : f3.setVisible(false);
                  
                         break;
                         }}
public void windowClosing(WindowEvent e)
{
if(e.getSource() == f)
{
if(!(Final.equals(ta.getText())))
{f4.setVisible(true);
d = 1;
}else{
Window w = e.getWindow();
f4.setVisible(false);
w.setVisible(false);
w.dispose();
System.exit(0);}}
else
 if(e.getSource() == f1)
{Window w = e.getWindow();
w.setVisible(false);
}
else
if(e.getSource() ==  f2)
{Window w = e.getWindow();
w.setVisible(false);}
else
if(e.getSource() == f4)
{Window w = e.getWindow();
w.setVisible(false);}
else
{Window w = e.getWindow();
w.setVisible(false);}
}
public static void main(String args[])
{
notepad d = new notepad();
}
}   