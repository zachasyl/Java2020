{\rtf1\ansi\ansicpg1252\cocoartf2512
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww14920\viewh13980\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 \
IAnimationModel contains all the methods that we expect the AnimationModelImpl to have; addShape, addAnimation, removePreviousAnimation, and get shape.\
\
AnimationModelImpl of course implements all of these methods. It also contains two Java ArrayLists one for animations and one for shapes. These are added in the order they appear, according to start times. The Impl can also produce a string using stringBuilder to return all the shape and animation descriptions as a string.\
\
IAnimation contains all methods that any animation class should have. We probably need to change this and add an abstract class or maybe use an adapter because not each animation class uses EVERY method in IAnimation.\
\
The classes that implement Animation are MoveAnimation, ScaleAnimation, and ChangeColor. Each contains getters, a tostring method, and an appropriate constructor. For instance, change color has a constructor that takes in a shape and a color and a start and end time (the time during which the color will transform). Its constructor updates its attribute String OldColor and String newColor and sets its type as enum CHANGECOLOR.\
\
Most of the animation constructors take in an abstract shape in order to create the animation. \
\
The abstract class AbstractShape utilizes some but not all of the methods in the Shapes interface. The abstract class is extended by two classes, Oval and Rectangle, which, together with the abstract class, utilize all the methods of the interface. As of yet, neither Oval or Rectangle necessarily need to override the body of the methods in the abstract shape class, but oval does have a getRadius method unique to it (which was opted for instead of overriding getWidth from abstract to instead return radius since this allows Oval to have getWidth or getRadius and getWidth is just diameter).\
\
Every shape has a color. We import the java color class which creates a color composed of three numbers up to 255. Our TheColor class extends Color for the purpose of overriding its toString so that we can print the color as a string when printing the shape object description.\
\
We use enums to keep track of the only allowed ShapeType and AnimationTypes supported by the program so far.\
\
Most of our variables are protected so that they can be used by any classes in the model. For instance, the arrays are protected rather than private so that the test classes can use them. Certain variables for instance in ChangeColor are private since we do not expect them to be used by other classes.\
\
We have a separate test class for animations and shapes. The animation tests also work with the arrays and test adding and reading from the arrays.\
\
\
}