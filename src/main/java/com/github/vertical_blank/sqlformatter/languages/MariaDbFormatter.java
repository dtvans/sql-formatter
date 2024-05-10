package com.github.vertical_blank.sqlformatter.languages;

import com.github.vertical_blank.sqlformatter.core.AbstractFormatter;
import com.github.vertical_blank.sqlformatter.core.DialectConfig;
import com.github.vertical_blank.sqlformatter.core.FormatConfig;
import com.github.vertical_blank.sqlformatter.core.util.Util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MariaDbFormatter extends AbstractFormatter {

    private static final List<String> reservedWords =
            Arrays.asList(
                    "ACCESSIBLE",
                    "ADD",
                    "ALL",
                    "ALTER",
                    "ANALYZE",
                    "AND",
                    "AS",
                    "ASC",
                    "ASENSITIVE",
                    "BEFORE",
                    "BETWEEN",
                    "BIGINT",
                    "BINARY",
                    "BLOB",
                    "BOTH",
                    "BY",
                    "CALL",
                    "CASCADE",
                    "CASE",
                    "CHANGE",
                    "CHAR",
                    "CHARACTER",
                    "CHECK",
                    "COLLATE",
                    "COLUMN",
                    "CONDITION",
                    "CONSTRAINT",
                    "CONTINUE",
                    "CONVERT",
                    "CREATE",
                    "CROSS",
                    "CURRENT_DATE",
                    "CURRENT_ROLE",
                    "CURRENT_TIME",
                    "CURRENT_TIMESTAMP",
                    "CURRENT_USER",
                    "CURSOR",
                    "DATABASE",
                    "DATABASES",
                    "DAY_HOUR",
                    "DAY_MICROSECOND",
                    "DAY_MINUTE",
                    "DAY_SECOND",
                    "DEC",
                    "DECIMAL",
                    "DECLARE",
                    "DEFAULT",
                    "DELAYED",
                    "DELETE",
                    "DESC",
                    "DESCRIBE",
                    "DETERMINISTIC",
                    "DISTINCT",
                    "DISTINCTROW",
                    "DIV",
                    "DO_DOMAIN_IDS",
                    "DOUBLE",
                    "DROP",
                    "DUAL",
                    "EACH",
                    "ELSE",
                    "ELSEIF",
                    "ENCLOSED",
                    "ESCAPED",
                    "EXCEPT",
                    "EXISTS",
                    "EXIT",
                    "EXPLAIN",
                    "FALSE",
                    "FETCH",
                    "FLOAT",
                    "FLOAT4",
                    "FLOAT8",
                    "FOR",
                    "FORCE",
                    "FOREIGN",
                    "FROM",
                    "FULLTEXT",
                    "GENERAL",
                    "GRANT",
                    "GROUP",
                    "HAVING",
                    "HIGH_PRIORITY",
                    "HOUR_MICROSECOND",
                    "HOUR_MINUTE",
                    "HOUR_SECOND",
                    "IF",
                    "IGNORE",
                    "IGNORE_DOMAIN_IDS",
                    "IGNORE_SERVER_IDS",
                    "IN",
                    "INDEX",
                    "INFILE",
                    "INNER",
                    "INOUT",
                    "INSENSITIVE",
                    "INSERT",
                    "INT",
                    "INT1",
                    "INT2",
                    "INT3",
                    "INT4",
                    "INT8",
                    "INTEGER",
                    "INTERSECT",
                    "INTERVAL",
                    "INTO",
                    "IS",
                    "ITERATE",
                    "JOIN",
                    "KEY",
                    "KEYS",
                    "KILL",
                    "LEADING",
                    "LEAVE",
                    "LEFT",
                    "LIKE",
                    "LIMIT",
                    "LINEAR",
                    "LINES",
                    "LOAD",
                    "LOCALTIME",
                    "LOCALTIMESTAMP",
                    "LOCK",
                    "LONG",
                    "LONGBLOB",
                    "LONGTEXT",
                    "LOOP",
                    "LOW_PRIORITY",
                    "MASTER_HEARTBEAT_PERIOD",
                    "MASTER_SSL_VERIFY_SERVER_CERT",
                    "MATCH",
                    "MAXVALUE",
                    "MEDIUMBLOB",
                    "MEDIUMINT",
                    "MEDIUMTEXT",
                    "MIDDLEINT",
                    "MINUTE_MICROSECOND",
                    "MINUTE_SECOND",
                    "MOD",
                    "MODIFIES",
                    "NATURAL",
                    "NOT",
                    "NO_WRITE_TO_BINLOG",
                    "NULL",
                    "NUMERIC",
                    "ON",
                    "OPTIMIZE",
                    "OPTION",
                    "OPTIONALLY",
                    "OR",
                    "ORDER",
                    "OUT",
                    "OUTER",
                    "OUTFILE",
                    "OVER",
                    "PAGE_CHECKSUM",
                    "PARSE_VCOL_EXPR",
                    "PARTITION",
                    "POSITION",
                    "PRECISION",
                    "PRIMARY",
                    "PROCEDURE",
                    "PURGE",
                    "RANGE",
                    "READ",
                    "READS",
                    "READ_WRITE",
                    "REAL",
                    "RECURSIVE",
                    "REF_SYSTEM_ID",
                    "REFERENCES",
                    "REGEXP",
                    "RELEASE",
                    "RENAME",
                    "REPEAT",
                    "REPLACE",
                    "REQUIRE",
                    "RESIGNAL",
                    "RESTRICT",
                    "RETURN",
                    "RETURNING",
                    "REVOKE",
                    "RIGHT",
                    "RLIKE",
                    "ROWS",
                    "SCHEMA",
                    "SCHEMAS",
                    "SECOND_MICROSECOND",
                    "SELECT",
                    "SENSITIVE",
                    "SEPARATOR",
                    "SET",
                    "SHOW",
                    "SIGNAL",
                    "SLOW",
                    "SMALLINT",
                    "SPATIAL",
                    "SPECIFIC",
                    "SQL",
                    "SQLEXCEPTION",
                    "SQLSTATE",
                    "SQLWARNING",
                    "SQL_BIG_RESULT",
                    "SQL_CALC_FOUND_ROWS",
                    "SQL_SMALL_RESULT",
                    "SSL",
                    "STARTING",
                    "STATS_AUTO_RECALC",
                    "STATS_PERSISTENT",
                    "STATS_SAMPLE_PAGES",
                    "STRAIGHT_JOIN",
                    "TABLE",
                    "TERMINATED",
                    "THEN",
                    "TINYBLOB",
                    "TINYINT",
                    "TINYTEXT",
                    "TO",
                    "TRAILING",
                    "TRIGGER",
                    "TRUE",
                    "UNDO",
                    "UNION",
                    "UNIQUE",
                    "UNLOCK",
                    "UNSIGNED",
                    "UPDATE",
                    "USAGE",
                    "USE",
                    "USING",
                    "UTC_DATE",
                    "UTC_TIME",
                    "UTC_TIMESTAMP",
                    "VALUES",
                    "VARBINARY",
                    "VARCHAR",
                    "VARCHARACTER",
                    "VARYING",
                    "WHEN",
                    "WHERE",
                    "WHILE",
                    "WINDOW",
                    "WITH",
                    "WRITE",
                    "XOR",
                    "YEAR_MONTH",
                    "ZEROFILL");

    private static final List<String> reservedTopLevelWords =
            Arrays.asList(
                    "ADD",
                    "ALTER COLUMN",
                    "ALTER TABLE",
                    "DELETE FROM",
                    "EXCEPT",
                    "FROM",
                    "GROUP BY",
                    "HAVING",
                    "INSERT INTO",
                    "INSERT",
                    "LIMIT",
                    "ORDER BY",
                    "SELECT",
                    "SET",
                    "UPDATE",
                    "VALUES",
                    "WHERE");

    private static final List<String> reservedTopLevelWordsNoIndent =
            Arrays.asList("INTERSECT", "INTERSECT ALL", "UNION", "UNION ALL");

    private static final List<String> reservedNewlineWords =
            Arrays.asList(
                    "AND",
                    "ELSE",
                    "OR",
                    "WHEN",
                    // joins
                    "JOIN",
                    "INNER JOIN",
                    "LEFT JOIN",
                    "LEFT OUTER JOIN",
                    "RIGHT JOIN",
                    "RIGHT OUTER JOIN",
                    "CROSS JOIN",
                    "NATURAL JOIN",
                    // non-standard joins
                    "STRAIGHT_JOIN",
                    "NATURAL LEFT JOIN",
                    "NATURAL LEFT OUTER JOIN",
                    "NATURAL RIGHT JOIN",
                    "NATURAL RIGHT OUTER JOIN");

    @Override
    public DialectConfig dialectConfig() {
        return DialectConfig.builder()
                .reservedWords(reservedWords)
                .reservedTopLevelWords(reservedTopLevelWords)
                .reservedTopLevelWordsNoIndent(reservedTopLevelWordsNoIndent)
                .reservedNewlineWords(reservedNewlineWords)
                .stringTypes(
                        Arrays.asList(
                                StringLiteral.DOUBLE_QUOTE,
                                StringLiteral.SINGLE_QUOTE,
                                StringLiteral.BACK_QUOTE,
                                StringLiteral.BRACKET))
                .openParens(Arrays.asList("(", "CASE"))
                .closeParens(Arrays.asList(")", "END"))
                .indexedPlaceholderTypes(Collections.singletonList("?"))
                .namedPlaceholderTypes(Collections.emptyList())
                .lineCommentTypes(Arrays.asList("--", "#"))
                .specialWordChars(Arrays.asList("@"))
                .operators(Arrays.asList(":=", "<<", ">>", "!=", "<>", "<=>", "&&", "||"))
                .placeholders(Util.PLACEHOLDERS)
                .build();
    }

    public MariaDbFormatter(FormatConfig cfg) {
        super(cfg);
    }
}
