import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Pos;
import java.io.File;
import javafx.geometry.Insets;

public class DressUp extends Application{

    int i = 1;
    //position variables
    int Layer = 1;
    int layer1X = 0;
    int layer1Y = 0;
    int layer2X = 0;
    int layer2Y = 0;
    int layer3X = 0;
    int layer3Y = 0;
    int layer4X = 0;
    int layer4Y = 0;
    int layer5X = 0;
    int layer5Y = 0;
    int layer6X = 0;
    int layer6Y = 0;
    int layer7X = 0;
    int layer7Y = 0;

    ////background layer stuffs
    //file count for background.
    File bgfile = new File("backgrounds");
    int bgcount = bgfile.list().length;
    int currentpage = 1;

    Image image = new Image("backgrounds\\" + currentpage + ".png");
    ImageView background = new ImageView(image);


    ////upper top
    //
    File uptopfile = new File("uppertop");
    int uptopnum = uptopfile.list().length;
    int currentpageUT = 1;

    Image imageUT = new Image("uppertop\\" + currentpageUT + ".png");
    ImageView backgroundUT = new ImageView(imageUT);

    ////upper bot
    //
    File upbotfile = new File("upperbot");
    int upbotnum = upbotfile.list().length;
    int currentpageUB = 1;

    Image imageUB = new Image("upperbot\\" + currentpageUB + ".png");
    ImageView backgroundUB = new ImageView(imageUB);

    ////lower top
    //
    File lowtopfile = new File("lowertop");
    int lowtopnum = lowtopfile.list().length;
    int currentpageLT = 1;

    Image imageLT = new Image("lowertop\\" + currentpageLT + ".png");
    ImageView backgroundLT = new ImageView(imageLT);

    ////lower bot
    //
    File lowbotfile = new File("lowerbot");
    int lowbotnum = lowbotfile.list().length;
    int currentpageLB = 1;

    Image imageLB = new Image("lowerbot\\" + currentpageLB + ".png");
    ImageView backgroundLB = new ImageView(imageLB);


    ////accessories
    File accfile = new File("accessory");
    int accnum = accfile.list().length;
    int currentpageAcc = 1;

    Image imageAcc = new Image("accessory\\" + currentpageAcc + ".png");
    ImageView backgroundAcc = new ImageView(imageAcc);

    ////hats
    File hatfile = new File("hat");
    int hatnum = hatfile.list().length;
    int currentpageHat = 1;

    Image imageHat = new Image("hat\\" + currentpageLB + ".png");
    ImageView backgroundHat = new ImageView(imageHat);

    ////subjects
    File subjectsfile = new File("subjects");
    int subjectsnum = subjectsfile.list().length;
    int currentpageSubject = 1;

    Image imageSubject = new Image("subjects\\" + currentpageSubject + ".png");
    ImageView backgroundSubject = new ImageView(imageSubject);

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        //Buttons
        Button rightbtn[] = new Button[]{
                new Button("->"),
                new Button("->"),
                new Button("->"),
                new Button("->"),
                new Button("->"),
                new Button("->"),
                new Button("->"),
                new Button("->"),
        };

        //
        Button leftbtn[] = new Button[]{
                new Button("<-"),
                new Button("<-"),
                new Button("<-"),
                new Button("<-"),
                new Button("<-"),
                new Button("<-"),
                new Button("<-"),
                new Button("<-"),
        };

        //position pane setup
        Button posUPbtn = new Button("^");
        Button posBOTbtn = new Button("V");
        Button posRIGHTbtn = new Button(">");
        Button posLEFTbtn = new Button("<");
        Label Target = new Label("");
        Target.setAlignment(Pos.CENTER);
        HBox posbtnbox = new HBox();
        posbtnbox.setSpacing(10);
        posbtnbox.setPadding(new Insets(0, 0, 0, 10));
        posbtnbox.getChildren().add(posUPbtn);
        posbtnbox.getChildren().add(posBOTbtn);
        posbtnbox.getChildren().add(posRIGHTbtn);
        posbtnbox.getChildren().add(posLEFTbtn);
        posbtnbox.getChildren().add(Target);


        //
        Button number[] = new Button[]{
                new Button("Background #" + String.valueOf(currentpage)),
                new Button("Upper Top #" + String.valueOf(currentpage)),
                new Button("Upper Bottom #" + String.valueOf(currentpage)),
                new Button("Lower Top #" + String.valueOf(currentpage)),
                new Button("Lower Bottom #" + String.valueOf(currentpage)),
                new Button("Accessories #" + String.valueOf(currentpage)),
                new Button("Hats #" + String.valueOf(currentpage)),
                new Button("Character #" + String.valueOf(currentpage)),
        };
        //
        HBox btncontainer = new HBox();
        VBox btnboxes = new VBox();
        HBox btnbox1 = new HBox();
        HBox btnbox2 = new HBox();
        btnboxes.getChildren().add(btnbox1);
        btnboxes.getChildren().add(btnbox2);
        btncontainer.getChildren().add(btnboxes);
        btncontainer.getChildren().add(posbtnbox);

        for (i = 0; i<8; i++){
            if (i<4){
                btnbox1.getChildren().add(leftbtn[i]);
                btnbox1.getChildren().add(number[i]);
                number[i].setPrefSize(120,20);
                btnbox1.getChildren().add(rightbtn[i]);
            }
            if (i>=4){
                btnbox2.getChildren().add(leftbtn[i]);
                btnbox2.getChildren().add(number[i]);
                number[i].setPrefSize(120,20);
                btnbox2.getChildren().add(rightbtn[i]);
            }

            //set 1
            if (i == 0){
                rightbtn[i].setOnAction((ActionEvent)->{
                    if (currentpage <= bgcount){
                        currentpage++;
                    }
                    if (currentpage > bgcount){
                        currentpage = 1;
                    }
                    Layer = 1;
                    Target.setText("Background");
                    background.setImage(new Image("backgrounds\\" + currentpage + ".png"));
                    number[0].setText("Background #" + String.valueOf(currentpage));
                });
                leftbtn[i].setOnAction((ActionEvent)->{
                    if (currentpage != 1){
                        currentpage--;
                    }
                    else{
                        currentpage = bgcount;
                    }
                    Layer = 1;
                    Target.setText("Background");
                    background.setImage(new Image("backgrounds\\" + currentpage + ".png"));
                    number[0].setText("Background #" + String.valueOf(currentpage));
                });
                number[i].setOnAction((ActionEvent)->{
                    Layer = 1;
                    Target.setText("Background");
                });
            }
            //set 2
            if (i == 1){
                rightbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageUT <= uptopnum){
                        currentpageUT++;
                    }
                    if (currentpageUT > uptopnum){
                        currentpageUT = 1;
                    }
                    Layer = 2;
                    Target.setText("Upper Top");
                    backgroundUT.setImage(new Image("uppertop\\" + currentpageUT + ".png"));
                    number[1].setText("Upper Top #" + String.valueOf(currentpageUT));
                });
                leftbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageUT != 1){
                        currentpageUT--;
                    }
                    else{
                        currentpageUT = uptopnum;
                    }
                    Layer = 2;
                    Target.setText("Upper Top");
                    backgroundUT.setImage(new Image("uppertop\\" + currentpageUT + ".png"));
                    number[1].setText("Upper Top #" + String.valueOf(currentpageUT));
                });
                number[i].setOnAction((ActionEvent)->{
                    Layer = 2;
                    Target.setText("Upper Top");
                });
            }
            //set 3
            if (i == 2){
                rightbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageUB <= upbotnum){
                        currentpageUB++;
                    }
                    if (currentpageUB > upbotnum){
                        currentpageUB = 1;
                    }
                    Layer = 3;
                    Target.setText("Upper Bottom");
                    backgroundUB.setImage(new Image("upperbot\\" + currentpageUB + ".png"));
                    number[2].setText("Upper Bot #" + String.valueOf(currentpageUB));
                });
                leftbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageUB != 1){
                        currentpageUB--;
                    }
                    else{
                        currentpageUB = upbotnum;
                    }
                    Layer = 3;
                    Target.setText("Upper Bottom");
                    backgroundUB.setImage(new Image("upperbot\\" + currentpageUB + ".png"));
                    number[2].setText("Upper Bot #" + String.valueOf(currentpageUB));
                });
                number[i].setOnAction((ActionEvent)->{
                    Layer = 3;
                    Target.setText("Upper Bottom");
                });
            }
            //set 4
            if (i == 3){
                rightbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageLT <= lowtopnum){
                        currentpageLT++;
                    }
                    if (currentpageLT > lowtopnum){
                        currentpageLT = 1;
                    }
                    Layer = 4;
                    Target.setText("Lower Top");
                    backgroundLT.setImage(new Image("lowertop\\" + currentpageLT + ".png"));
                    number[3].setText("Lower Top #" + String.valueOf(currentpageLT));
                });
                leftbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageLT != 1){
                        currentpageLT--;
                    }
                    else{
                        currentpageLT = lowtopnum;
                    }
                    Layer = 4;
                    Target.setText("Lower Top");
                    backgroundLT.setImage(new Image("lowertop\\" + currentpageLT + ".png"));
                    number[3].setText("Lower Top #" + String.valueOf(currentpageLT));
                });
                number[i].setOnAction((ActionEvent)->{
                    Layer = 4;
                    Target.setText("Lower Top");
                });
            }
            //set 5 lb
            if (i == 4){
                rightbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageLB <= lowbotnum){
                        currentpageLB++;
                    }
                    if (currentpageLB > lowbotnum){
                        currentpageLB = 1;
                    }
                    Layer = 5;
                    Target.setText("Lower Bottom");
                    backgroundLB.setImage(new Image("lowerbot\\" + currentpageLB + ".png"));
                    number[4].setText("Lower Bottom #" + String.valueOf(currentpageLB));
                });
                leftbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageLB != 1){
                        currentpageLB--;
                    }
                    else{
                        currentpageLB = lowbotnum;
                    }
                    Layer = 5;
                    Target.setText("Lower Bottom");
                    backgroundLB.setImage(new Image("lowerbot\\" + currentpageLB + ".png"));
                    number[4].setText("Lower Bottom #" + String.valueOf(currentpageLB));
                });
                number[i].setOnAction((ActionEvent)->{
                    Layer = 5;
                    Target.setText("Lower Bottom");
                });
            }
            //set 6 acc
            if (i == 5){
                rightbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageAcc <= accnum){
                        currentpageAcc++;
                    }
                    if (currentpageAcc > accnum){
                        currentpageAcc = 1;
                    }
                    Layer = 6;
                    Target.setText("Accessories");
                    backgroundAcc.setImage(new Image("accessory\\" + currentpageAcc + ".png"));
                    number[5].setText("Accessories #" + String.valueOf(currentpageAcc));
                });
                leftbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageAcc != 1){
                        currentpageAcc--;
                    }
                    else{
                        currentpageAcc = accnum;
                    }
                    Layer = 6;
                    Target.setText("Accessories");
                    backgroundAcc.setImage(new Image("accessory\\" + currentpageAcc + ".png"));
                    number[5].setText("Accessories #" + String.valueOf(currentpageAcc));
                });
                number[i].setOnAction((ActionEvent)->{
                    Layer = 6;
                    Target.setText("Accessories");
                });
            }
            //set 7 hats
            if (i == 6){
                rightbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageHat <= hatnum){
                        currentpageHat++;
                    }
                    if (currentpageHat > hatnum){
                        currentpageHat = 1;
                    }
                    Layer = 7;
                    Target.setText("Hats");
                    backgroundHat.setImage(new Image("hat\\" + currentpageHat + ".png"));
                    number[6].setText("Hats #" + String.valueOf(currentpageHat));
                });
                leftbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageHat != 1){
                        currentpageHat--;
                    }
                    else{
                        currentpageHat = hatnum;
                    }
                    Layer = 7;
                    Target.setText("Hats");
                    backgroundHat.setImage(new Image("hat\\" + currentpageHat + ".png"));
                    number[6].setText("Hats #" + String.valueOf(currentpageHat));
                });
                number[i].setOnAction((ActionEvent)->{
                    Layer = 7;
                    Target.setText("Hats");
                });
            }
            //set 8 subjects
            if (i == 7){
                rightbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageSubject <= subjectsnum){
                        currentpageSubject++;
                    }
                    if (currentpageSubject > subjectsnum){
                        currentpageSubject = 1;
                    }
                    Layer = 8;
                    Target.setText("Character");
                    backgroundSubject.setImage(new Image("subjects\\" + currentpageSubject + ".png"));
                    number[7].setText("Character #" + String.valueOf(currentpageSubject));
                });
                leftbtn[i].setOnAction((ActionEvent)->{
                    if (currentpageSubject != 1){
                        currentpageSubject--;
                    }
                    else{
                        currentpageSubject = subjectsnum;
                    }
                    Layer = 8;
                    Target.setText("Character");
                    backgroundSubject.setImage(new Image("subjects\\" + currentpageSubject + ".png"));
                    number[7].setText("Character #" + String.valueOf(currentpageSubject));
                });
                number[i].setOnAction((ActionEvent)->{
                    Layer = 8;
                    Target.setText("Character");
                });
            }



            posUPbtn.setOnAction((ActionEvent)->{
                if (Layer == 1){
                    layer1Y = layer1Y - 10;
                    backgroundUT.setLayoutY(layer1Y);
                }
                if (Layer == 2){
                    layer2Y = layer2Y - 10;
                    backgroundUB.setLayoutY(layer2Y);
                }
                if (Layer == 3){
                    layer3Y = layer3Y - 10;
                    backgroundLT.setLayoutY(layer3Y);
                }
                if (Layer == 4){
                    layer4Y = layer4Y - 10;
                    backgroundLB.setLayoutY(layer4Y);
                }
                if (Layer == 5){
                    layer5Y = layer5Y - 10;
                    backgroundAcc.setLayoutY(layer5Y);
                }
                if (Layer == 6){
                    layer6Y = layer6Y - 10;
                    backgroundHat.setLayoutY(layer6Y);
                }
                if (Layer == 7){
                    layer7Y = layer7Y - 10;
                    backgroundSubject.setLayoutY(layer7Y);
                }
            });
            posBOTbtn.setOnAction((ActionEvent)->{
                if (Layer == 1){
                    layer1Y = layer1Y + 10;
                    backgroundUT.setLayoutY(layer1Y);
                }
                if (Layer == 2){
                    layer2Y = layer2Y + 10;
                    backgroundUB.setLayoutY(layer2Y);
                }
                if (Layer == 3){
                    layer3Y = layer3Y + 10;
                    backgroundLT.setLayoutY(layer3Y);
                }
                if (Layer == 4){
                    layer4Y = layer4Y + 10;
                    backgroundLB.setLayoutY(layer4Y);
                }
                if (Layer == 5){
                    layer5Y = layer5Y + 10;
                    backgroundAcc.setLayoutY(layer5Y);
                }
                if (Layer == 6){
                    layer6Y = layer6Y + 10;
                    backgroundHat.setLayoutY(layer6Y);
                }
                if (Layer == 7){
                    layer7Y = layer7Y + 10;
                    backgroundSubject.setLayoutY(layer7Y);
                }
            });
            posRIGHTbtn.setOnAction((ActionEvent)->{
                if (Layer == 1){
                    layer1X = layer1X + 10;
                    backgroundUT.setLayoutX(layer1X);
                }
                if (Layer == 2){
                    layer2X = layer2X + 10;
                    backgroundUB.setLayoutX(layer2X);
                }
                if (Layer == 3){
                    layer3X = layer3X + 10;
                    backgroundLT.setLayoutX(layer3X);
                }
                if (Layer == 4){
                    layer4X = layer4X + 10;
                    backgroundLB.setLayoutX(layer4X);
                }
                if (Layer == 5){
                    layer5X = layer5X + 10;
                    backgroundAcc.setLayoutX(layer5X);
                }
                if (Layer == 6){
                    layer6X = layer6X + 10;
                    backgroundHat.setLayoutX(layer6X);
                }
                if (Layer == 7){
                    layer7X = layer7X + 10;
                    backgroundSubject.setLayoutX(layer7X);
                }
            });
            posLEFTbtn.setOnAction((ActionEvent)->{
                if (Layer == 1){
                    layer1X = layer1X - 10;
                    backgroundUT.setLayoutX(layer1X);
                }
                if (Layer == 2){
                    layer2X = layer2X - 10;
                    backgroundUB.setLayoutX(layer2X);
                }
                if (Layer == 3){
                    layer3X = layer3X - 10;
                    backgroundLT.setLayoutX(layer3X);
                }
                if (Layer == 4){
                    layer4X = layer4X - 10;
                    backgroundLB.setLayoutX(layer4X);
                }
                if (Layer == 5){
                    layer5X = layer5X - 10;
                    backgroundAcc.setLayoutX(layer5X);
                }
                if (Layer == 6){
                    layer6X = layer6X - 10;
                    backgroundHat.setLayoutX(layer6X);
                }
                if (Layer == 7){
                    layer7X = layer7X - 10;
                    backgroundSubject.setLayoutX(layer7X);
                }
            });
        }

        btnbox1.setAlignment(Pos.CENTER_LEFT);
        btnbox2.setAlignment(Pos.CENTER_LEFT);

        Pane pane = new VBox();
        Pane picture = new Pane();
        pane.getChildren().add(picture);
        picture.getChildren().add(background);
        picture.getChildren().add(backgroundSubject);
        picture.getChildren().add(backgroundLT);
        picture.getChildren().add(backgroundLB);
        picture.getChildren().add(backgroundUT);
        picture.getChildren().add(backgroundUB);
        picture.getChildren().add(backgroundAcc);
        picture.getChildren().add(backgroundHat);
        pane.getChildren().add(btncontainer);

        Scene scene = new Scene(pane);

        stage.setTitle("Dress UP");
        stage.setScene(scene);
        stage.show();
    }
}