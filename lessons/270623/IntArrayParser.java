public class IntArrayParser {
    private String line;

    private int idxStartNumber = 0;
    private int idxEndNumber = 0;
    private int idxNumber = -1;


    public void reset() {
        idxStartNumber = idxEndNumber = 0;
        idxNumber = -1;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    /**
     * Подсчет количества целых чисел в строке
     * @return Количество целых чисел
     */
    public int getNumbersCount() {
        int numbers = 0;

        if (line != null) {
            boolean isDelimiter = true;
            for (char c : line.toCharArray()) {
                if (isBlank(c)) {
                    //TODO: Пробельный символ не может быть в середине числа
                    continue;
                }
                if (isDelimiter(c)) {
                    if (!isDelimiter) {
                        numbers++;
                        isDelimiter = true;
                    }
                } else {
                    if (isDelimiter) {
                        isDelimiter = false;
                    }
                }
            }
            if (!isDelimiter) {
                numbers++;
            }
        }

        return numbers;
    }

    public boolean isBlank(char c) {
        return Character.isWhitespace(c);
    }

    public boolean isDelimiter(char c) {
        return c == ',';
    }

    /**
     * Преобразование строки в число
     * @return Число
     */
    private int parseNumber() {
        int number = 0;

        for(int i = idxStartNumber; i <= idxEndNumber; i++) {
            int n = line.charAt(i) - '0';
            number = n + number * 10;
        }

        return number;
    }

    public void parse(int[] numbers) {
        if (line == null || line.length() == 0) {
            return;
        }
        reset();

        boolean isDelimiter = true;
        for(int i = 0; i < line.length(); i++) {
            final char c = line.charAt(i);
            if (isBlank(c)) {
                //TODO: Пробельный символ не может быть в середине числа
                //BUG: Если разделитель содержит пробельные символы, то результат выдается неправильный
                continue;
            }
            if (isDelimiter(c)) {
                if (!isDelimiter) {
                    idxNumber++;
                    idxEndNumber = i - 1;
                    isDelimiter = true;
                    numbers[idxNumber] = parseNumber();
                }
            } else {
                if (isDelimiter) {
                    idxStartNumber = i;
                    isDelimiter = false;
                }
            }
        }
        if (!isDelimiter) {
            idxEndNumber = line.length() - 1;
            idxNumber++;
            numbers[idxNumber] = parseNumber();
        }
    }
}
