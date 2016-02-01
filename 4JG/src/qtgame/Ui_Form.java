package qtgame;


/********************************************************************************
 ** Form generated from reading ui file 'MyGame.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Form implements com.trolltech.qt.QUiForm<QWidget>
{
    public QHBoxLayout horizontalLayout_3;
    public QVBoxLayout verticalLayout_3;
    public QGridLayout gridLayout_4;
    public QLabel lSum;
    public QLabel label_2;
    public QLabel label_4;
    public QLabel label_5;
    public QLabel lOPen;
    public QLabel label_3;
    public QLabel lCorrect;
    public QLabel lWrong;
    public QLabel label_6;
    public QLabel lGames;
    public QGridLayout gridLayout;
    public QGridLayout gridLayout_3;
    public QVBoxLayout verticalLayout_2;
    public QGridLayout gridLayout_2;
    public QPushButton pButton0;
    public QPushButton pButton11;
    public QPushButton pButton12;
    public QPushButton pButton8;
    public QPushButton pButton3;
    public QPushButton pButton13;
    public QPushButton pButton2;
    public QPushButton pButton10;
    public QPushButton pButton1;
    public QPushButton pButton5;
    public QPushButton pButton6;
    public QPushButton pButton7;
    public QPushButton pButton4;
    public QPushButton pButton9;
    public QPushButton pButton14;
    public QVBoxLayout verticalLayout;
    public QHBoxLayout horizontalLayout_2;
    public QPushButton pNew;
    public QPushButton pExit;
    public QLabel label;

    public Ui_Form() { super(); }

    public void setupUi(QWidget Form)
    {
        Form.setObjectName("Form");
        Form.resize(new QSize(619, 229).expandedTo(Form.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(Form.sizePolicy().hasHeightForWidth());
        Form.setSizePolicy(sizePolicy);
        horizontalLayout_3 = new QHBoxLayout(Form);
        horizontalLayout_3.setObjectName("horizontalLayout_3");
        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3.setObjectName("verticalLayout_3");
        gridLayout_4 = new QGridLayout();
        gridLayout_4.setObjectName("gridLayout_4");
        lSum = new QLabel(Form);
        lSum.setObjectName("lSum");

        gridLayout_4.addWidget(lSum, 3, 1, 1, 1);

        label_2 = new QLabel(Form);
        label_2.setObjectName("label_2");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(label_2.sizePolicy().hasHeightForWidth());
        label_2.setSizePolicy(sizePolicy1);
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        label_2.setFont(font);

        gridLayout_4.addWidget(label_2, 0, 0, 1, 1);

        label_4 = new QLabel(Form);
        label_4.setObjectName("label_4");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(label_4.sizePolicy().hasHeightForWidth());
        label_4.setSizePolicy(sizePolicy2);
        QFont font1 = new QFont();
        font1.setBold(true);
        font1.setWeight(75);
        label_4.setFont(font1);

        gridLayout_4.addWidget(label_4, 2, 0, 1, 1);

        label_5 = new QLabel(Form);
        label_5.setObjectName("label_5");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(label_5.sizePolicy().hasHeightForWidth());
        label_5.setSizePolicy(sizePolicy3);
        QFont font2 = new QFont();
        font2.setBold(true);
        font2.setWeight(75);
        label_5.setFont(font2);

        gridLayout_4.addWidget(label_5, 3, 0, 1, 1);

        lOPen = new QLabel(Form);
        lOPen.setObjectName("lOPen");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(lOPen.sizePolicy().hasHeightForWidth());
        lOPen.setSizePolicy(sizePolicy4);

        gridLayout_4.addWidget(lOPen, 0, 1, 1, 1);

        label_3 = new QLabel(Form);
        label_3.setObjectName("label_3");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(label_3.sizePolicy().hasHeightForWidth());
        label_3.setSizePolicy(sizePolicy5);
        QFont font3 = new QFont();
        font3.setBold(true);
        font3.setWeight(75);
        label_3.setFont(font3);

        gridLayout_4.addWidget(label_3, 1, 0, 1, 1);

        lCorrect = new QLabel(Form);
        lCorrect.setObjectName("lCorrect");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(lCorrect.sizePolicy().hasHeightForWidth());
        lCorrect.setSizePolicy(sizePolicy6);

        gridLayout_4.addWidget(lCorrect, 1, 1, 1, 1);

        lWrong = new QLabel(Form);
        lWrong.setObjectName("lWrong");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(lWrong.sizePolicy().hasHeightForWidth());
        lWrong.setSizePolicy(sizePolicy7);

        gridLayout_4.addWidget(lWrong, 2, 1, 1, 1);

        label_6 = new QLabel(Form);
        label_6.setObjectName("label_6");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(label_6.sizePolicy().hasHeightForWidth());
        label_6.setSizePolicy(sizePolicy8);
        QFont font4 = new QFont();
        font4.setBold(true);
        font4.setItalic(true);
        font4.setWeight(75);
        label_6.setFont(font4);

        gridLayout_4.addWidget(label_6, 4, 0, 1, 1);

        lGames = new QLabel(Form);
        lGames.setObjectName("lGames");

        gridLayout_4.addWidget(lGames, 4, 1, 1, 1);


        verticalLayout_3.addLayout(gridLayout_4);


        horizontalLayout_3.addLayout(verticalLayout_3);

        gridLayout = new QGridLayout();
        gridLayout.setObjectName("gridLayout");
        gridLayout_3 = new QGridLayout();
        gridLayout_3.setObjectName("gridLayout_3");
        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2.setObjectName("verticalLayout_2");
        gridLayout_2 = new QGridLayout();
        gridLayout_2.setObjectName("gridLayout_2");
        pButton0 = new QPushButton(Form);
        pButton0.setObjectName("pButton0");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(pButton0.sizePolicy().hasHeightForWidth());
        pButton0.setSizePolicy(sizePolicy9);

        gridLayout_2.addWidget(pButton0, 0, 0, 1, 1);

        pButton11 = new QPushButton(Form);
        pButton11.setObjectName("pButton11");

        gridLayout_2.addWidget(pButton11, 2, 1, 1, 1);

        pButton12 = new QPushButton(Form);
        pButton12.setObjectName("pButton12");

        gridLayout_2.addWidget(pButton12, 2, 2, 1, 1);

        pButton8 = new QPushButton(Form);
        pButton8.setObjectName("pButton8");

        gridLayout_2.addWidget(pButton8, 1, 3, 1, 1);

        pButton3 = new QPushButton(Form);
        pButton3.setObjectName("pButton3");

        gridLayout_2.addWidget(pButton3, 0, 3, 1, 1);

        pButton13 = new QPushButton(Form);
        pButton13.setObjectName("pButton13");

        gridLayout_2.addWidget(pButton13, 2, 3, 1, 1);

        pButton2 = new QPushButton(Form);
        pButton2.setObjectName("pButton2");

        gridLayout_2.addWidget(pButton2, 0, 2, 1, 1);

        pButton10 = new QPushButton(Form);
        pButton10.setObjectName("pButton10");

        gridLayout_2.addWidget(pButton10, 2, 0, 1, 1);

        pButton1 = new QPushButton(Form);
        pButton1.setObjectName("pButton1");

        gridLayout_2.addWidget(pButton1, 0, 1, 1, 1);

        pButton5 = new QPushButton(Form);
        pButton5.setObjectName("pButton5");

        gridLayout_2.addWidget(pButton5, 1, 0, 1, 1);

        pButton6 = new QPushButton(Form);
        pButton6.setObjectName("pButton6");

        gridLayout_2.addWidget(pButton6, 1, 1, 1, 1);

        pButton7 = new QPushButton(Form);
        pButton7.setObjectName("pButton7");

        gridLayout_2.addWidget(pButton7, 1, 2, 1, 1);

        pButton4 = new QPushButton(Form);
        pButton4.setObjectName("pButton4");

        gridLayout_2.addWidget(pButton4, 0, 4, 1, 1);

        pButton9 = new QPushButton(Form);
        pButton9.setObjectName("pButton9");
        pButton9.setEnabled(true);

        gridLayout_2.addWidget(pButton9, 1, 4, 1, 1);

        pButton14 = new QPushButton(Form);
        pButton14.setObjectName("pButton14");

        gridLayout_2.addWidget(pButton14, 2, 4, 1, 1);


        verticalLayout_2.addLayout(gridLayout_2);


        gridLayout_3.addLayout(verticalLayout_2, 0, 0, 1, 1);


        gridLayout.addLayout(gridLayout_3, 1, 0, 1, 1);

        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        horizontalLayout_2.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        pNew = new QPushButton(Form);
        pNew.setObjectName("pNew");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(pNew.sizePolicy().hasHeightForWidth());
        pNew.setSizePolicy(sizePolicy10);

        horizontalLayout_2.addWidget(pNew);

        pExit = new QPushButton(Form);
        pExit.setObjectName("pExit");
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(pExit.sizePolicy().hasHeightForWidth());
        pExit.setSizePolicy(sizePolicy11);

        horizontalLayout_2.addWidget(pExit);


        verticalLayout.addLayout(horizontalLayout_2);


        gridLayout.addLayout(verticalLayout, 3, 0, 1, 1);

        label = new QLabel(Form);
        label.setObjectName("label");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(label.sizePolicy().hasHeightForWidth());
        label.setSizePolicy(sizePolicy12);
        QFont font5 = new QFont();
        font5.setPointSize(11);
        font5.setBold(true);
        font5.setWeight(75);
        label.setFont(font5);
        label.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label.setMidLineWidth(1);

        gridLayout.addWidget(label, 0, 0, 1, 1);


        horizontalLayout_3.addLayout(gridLayout);

        retranslateUi(Form);
        pExit.clicked.connect(Form, "close()");

        Form.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget Form)
    {
        Form.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Form", "MyGame", null));
        lSum.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "0", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "offen:", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "falsch", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "gesamt", null));
        lOPen.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "0", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "korrekt", null));
        lCorrect.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "0", null));
        lWrong.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "0", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Spiele", null));
        lGames.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "0", null));
        pButton0.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton11.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton12.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton8.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton3.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton13.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton2.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton10.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton1.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton5.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton6.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton7.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton4.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton9.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pButton14.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "PushButton", null));
        pNew.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Neu", null));
        pExit.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Ende", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Dr\u00fccken Sie die Buttons in aufsteigender Richtung!", null));
    } // retranslateUi

}

