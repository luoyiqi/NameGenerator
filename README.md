# NameGenerator
A name generator for 13 different languages.

##Languages available:
  - Arabic
  - Chinese
  - Dutch
  - English
  - French
  - German
  - Hindi
  - Italian
  - Japanese
  - Korean
  - Portuguese
  - Russian
  - Spanish
  
##Usage:

    // Initialize the generator with a certain language
    NameGenerator nameGenerator = new NameGenerator(NameGenerator.ENGLISH);
    
    // Get a random name
    String randomname = nameGenerator.nextName();
    
    // Get a girl's name
    String girlname = nameGenerator.nextName(Names.FEMALE);
    
    // Get a boy's name
    String boyname = nameGenerator.nextName(Names.MALE);



You can also set how many names you want:

    // Get a boy's name that contains 4 given names and 2 surnames
    nameGenerator.nextName(Names.MALE,4,2);

And the surnames to be used:

    nameGenerator.nextName(Names.MALE,4,new String[]{"Charles","Richards"});


###Example 1:
  
    NameGenerator nameGenerator = new NameGenerator(NameGenerator.ENGLISH);
    String randomname = nameGenerator.nextName();
    System.out.println(randomname);
Output:

    Tim Kenton Albert
###Example 2:
  
    NameGenerator nameGenerator = new NameGenerator(NameGenerator.ITALIAN);
    String name = nameGenerator.nextName(Names.FEMALE,3,new String[]{"Berlusconi"});
    System.out.println(name);
Output:

    Hilaria Agnese Imelda Berlusconi

###Example 3:
  
    // Disable westernized name form
    NameGenerator nameGenerator = new NameGenerator(NameGenerator.JAPANESE,false);
    String name = nameGenerator.nextName(Names.MALE);
    System.out.println(name);
Output:

    Hattori Keisuke

##Example of names generated:
    Kuaybah Al Amri
    Kum Ho-win 
    Koob Tymen Botha
    Barry Rusty Saltonstall
    Orable Pouget
    Millisent Frena Meisinger
    Mangla Anumodita Shanbhag
    Aurello Pasqu Lodovigo Lovato
    Kojima Atshushi 
    Jeon Hyang-Soon 
    Guilhermina Esmeralda Norma Figueiredo
    Debora Zhanna Larisa Naryshkin
    Generos Felippe Calvino Capella

##License:
    Copyright © 2015 Rúben Sousa rubensousa.mieti@gmail.com 
    This work is free. You can redistribute it and/or modify it under the terms
    of the Do What The Fuck You Want To Public License, Version 2, as published by Sam Hocevar.
    See the LICENSE file for more details.
