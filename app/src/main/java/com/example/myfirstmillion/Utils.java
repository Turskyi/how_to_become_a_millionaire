package com.example.myfirstmillion;

import java.util.ArrayList;

class Utils {

    static ArrayList<Question> setQuestionsBlock(int number) {
        ArrayList<Question> questions = new ArrayList<>();

        switch (number) {
            case 0:
                questions.add(new Question("Which insect shorted out an early supercomputer and inspired the term \"computer bug\"?", 0, new ArrayList<Option>() {{
                    add(new Option("Moth"));
                    add(new Option("Roach"));
                    add(new Option("Fly"));
                    add(new Option("Beetle"));
                }}));
                questions.add(new Question("Now used to refer to a cat, the word \"tabby\" " +
                        "is derived from the name of a district of what world capital?", 3, new ArrayList<Option>() {{
                    add(new Option("New Delhi"));
                    add(new Option("Cairo"));
                    add(new Option("Moscow"));
                    add(new Option("Baghdad"));
                }}));
                questions.add(new Question("Which of the following men does not have a chemical element named for him?", 2, new ArrayList<Option>() {{
                    add(new Option("Albert Einstein"));
                    add(new Option("Niels Bohr"));
                    add(new Option("Isaac Newton"));
                    add(new Option("Enrico Fermi"));
                }}));
                break;

            case 1:
                questions.add(new Question("A number one followed by one hundred zeros is known by what name?", 2, new ArrayList<Option>() {{
                    add(new Option("Googol"));
                    add(new Option("Megatron"));
                    add(new Option("Gigabit"));
                    add(new Option("Nanamote"));
                }}));
                questions.add(new Question("What is the offspring of a male lion and a female tiger called?", 2, new ArrayList<Option>() {{
                    add(new Option("Tigron"));
                    add(new Option("Tiglon"));
                    add(new Option("Liger"));
                    add(new Option(" Ligron"));
                }}));
                questions.add(new Question("Why it is not allowed to set the sizes in pixels?", 1, new ArrayList<Option>() {{
                    add(new Option("Without a reason"));
                    add(new Option("Difference in display"));
                    add(new Option("It is inconvenient"));
                    add(new Option("You have to count pixels"));
                }}));
                questions.add(new Question("What makeup product makes eyelashes appear longer?", 1, new ArrayList<Option>() {{
                    add(new Option("Blush"));
                    add(new Option("Mascara"));
                    add(new Option("Foundation"));
                    add(new Option("Lipstick"));
                }}));
                questions.add(new Question("What are layouts?", 0, new ArrayList<Option>() {{
                    add(new Option("Ways of positioning elements"));
                    add(new Option("Components of Android"));
                    add(new Option("Special format"));
                    add(new Option("Development environments"));
                }}));
                questions.add(new Question("The Earth is approximately how many miles away from the Sun?", 2, new ArrayList<Option>() {{
                    add(new Option("9.3 million"));
                    add(new Option("39 million"));
                    add(new Option("93 million"));
                    add(new Option("139 million"));
                }}));
                questions.add(new Question("What is a positive electrode called, in an electrolytic cell?", 2, new ArrayList<Option>() {{
                    add(new Option(" triode"));
                    add(new Option("cathode"));
                    add(new Option("anode"));
                    add(new Option("diode"));
                }}));
                questions.add(new Question("Which of the following landlocked countries is entirely contained within another country?", 0, new ArrayList<Option>() {{
                    add(new Option("Lesotho"));
                    add(new Option("Burkina Faso"));
                    add(new Option("Mongolia"));
                    add(new Option("Luxembourg"));
                }}));
                questions.add(new Question("Somebody described as 'butterfingers' would have a propensity for what?", 0, new ArrayList<Option>() {{
                    add(new Option("being clumsy"));
                    add(new Option("gardening"));
                    add(new Option("cookery"));
                    add(new Option("playing the piano"));
                }}));
                questions.add(new Question("Who is credited with inventing the first mass-produced helicopter?", 3, new ArrayList<Option>() {{
                    add(new Option("Elmer Sperry"));
                    add(new Option("Ferdinand von Zeppelin"));
                    add(new Option("Gottlieb Daimler"));
                    add(new Option("Igor Sikorsky"));
                }}));
                questions.add(new Question("Which word means a signed document in support of a particular action?", 3, new ArrayList<Option>() {{
                    add(new Option("position"));
                    add(new Option("partition"));
                    add(new Option("perforation"));
                    add(new Option("petition "));
                }}));
                questions.add(new Question("The US icon Uncle Sam was based on Samuel Wilson who worked during the War of 1812 as a what?", 1, new ArrayList<Option>() {{
                    add(new Option("Mail deliverer"));
                    add(new Option("Meat inspector"));
                    add(new Option("Historian"));
                    add(new Option("Weapons mechanic"));
                }}));
                questions.add(new Question("Which of these is another word for 'water divining'?", 1, new ArrayList<Option>() {{
                    add(new Option("Panning"));
                    add(new Option("Dowsing"));
                    add(new Option("Prospecting"));
                    add(new Option("Tapping"));
                }}));
                questions.add(new Question("Which of the following is not a definition of 'mortar'?", 1, new ArrayList<Option>() {{
                    add(new Option("Bowl"));
                    add(new Option("Grinding stick"));
                    add(new Option("Cement and water"));
                    add(new Option("Weapon"));
                }}));
                questions.add(new Question("Which of these words means 'wickedness'?", 1, new ArrayList<Option>() {{
                    add(new Option("Topography"));
                    add(new Option("Turpitude"));
                    add(new Option("Torpidity"));
                    add(new Option("Terpsichorean"));
                }}));
                break;

            default:
                break;
        }
        return questions;
    }
}
