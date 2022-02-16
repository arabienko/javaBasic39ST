package by.arabienko.bean;

public enum TypeRegex {
    PARAGRAPH, SENTENCE, LEXEME, WORD, BIT_EXPR,
    DELIM_PARAGRAPH, DELIM_SENTENCE, DELIM_LEXEME, DELIM_SYMBOL;

    private String RegexForSplit;

    static {
        PARAGRAPH.RegexForSplit ="((?:[^\\n\\t][\\n]?)+)";

        SENTENCE.RegexForSplit =
                "((\\s*)[А-ЯA-Z]((etc.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!:])";

        LEXEME.RegexForSplit =
                "((\\s*)[А-ЯA-Zа-яa-z\\p{Punct}0-9]*(\\p{Blank}|\\p{Punct})|(\\p{Blank}))";

        WORD.RegexForSplit =
                "(?x)(\\w+)|((\\s*)[\\p{Punct}0-9]{4,})|(\\p{Punct}+)";

        BIT_EXPR.RegexForSplit =
                "(\\s*)[\\p{Punct}0-9]{4,}";
        DELIM_PARAGRAPH.RegexForSplit = "\n";
        DELIM_SENTENCE.RegexForSplit = " ";
        DELIM_LEXEME.RegexForSplit = "";
        DELIM_SYMBOL.RegexForSplit = "";
    }

    public String getRegexForSplit() {
        return RegexForSplit;
    }
}
