// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/lexico/Lexer.flex

import java_cup.runtime.*;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class LexicalElements implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int BLOCK_COMMENT = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\36\u0200\1\u0300\1\u0400\266\u0200\10\u0500\u1020\u0200";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\3\3\22\0\1\4\1\5\1\0"+
    "\1\6\1\5\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\0\1\20\12\21\1\22\1\23"+
    "\1\24\1\25\1\26\2\5\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\35\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\35\1\46\1\47\1\50"+
    "\1\51\1\35\1\52\1\35\1\53\1\35\1\54\1\0"+
    "\1\55\1\5\1\35\1\0\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\35\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\35\1\46\1\47\1\50"+
    "\1\51\1\35\1\52\1\35\1\53\1\35\1\56\1\0"+
    "\1\57\7\0\1\3\252\0\2\60\115\0\1\61\u01a8\0"+
    "\2\3\u0100\0\1\62\325\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1536];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\5\1\6\1\1"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\6\1\21\1\6\15\22\1\23\1\24"+
    "\1\25\1\26\2\1\1\27\2\0\14\22\1\30\2\22"+
    "\1\31\4\22\1\30\2\0\1\32\4\22\1\0\4\22"+
    "\1\0\2\22\1\33\5\22\1\0\2\22\2\0\3\22"+
    "\2\34\3\22\2\35\1\22\1\0\5\22\1\0\1\36"+
    "\1\22\2\0\1\37\1\22\2\40\3\22\1\41\1\36"+
    "\1\22\1\42\3\22\1\0\2\43\1\42\5\22\1\0"+
    "\1\44\1\45\2\46\1\47\2\22\1\50\1\22\1\0"+
    "\1\22\2\51\2\52\1\53";

  private static int [] zzUnpackAction() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\146\0\146\0\146\0\146\0\146\0\146"+
    "\0\231\0\146\0\146\0\146\0\146\0\146\0\146\0\146"+
    "\0\314\0\146\0\146\0\377\0\u0132\0\u0165\0\u0198\0\u01cb"+
    "\0\u01fe\0\u0231\0\u0264\0\u0297\0\u02ca\0\u02fd\0\u0330\0\u0363"+
    "\0\u0396\0\u03c9\0\u03fc\0\146\0\146\0\146\0\146\0\u042f"+
    "\0\u0462\0\146\0\u0495\0\u0165\0\u04c8\0\u04fb\0\u052e\0\u0561"+
    "\0\u0594\0\u05c7\0\u05fa\0\u062d\0\u0660\0\u0693\0\u06c6\0\u06f9"+
    "\0\u02ca\0\u072c\0\u075f\0\u02ca\0\u0792\0\u07c5\0\u07f8\0\u082b"+
    "\0\146\0\u085e\0\u0891\0\146\0\u08c4\0\u08f7\0\u092a\0\u095d"+
    "\0\u0990\0\u09c3\0\u09f6\0\u0a29\0\u0a5c\0\u0a8f\0\u0ac2\0\u0af5"+
    "\0\u02ca\0\u0b28\0\u0b5b\0\u0b8e\0\u0bc1\0\u0bf4\0\u0c27\0\u0c5a"+
    "\0\u0c8d\0\u0cc0\0\u0cf3\0\u0d26\0\u0d59\0\u0d8c\0\u02ca\0\146"+
    "\0\u0dbf\0\u0df2\0\u0e25\0\u02ca\0\146\0\u0e58\0\u0e8b\0\u0ebe"+
    "\0\u0ef1\0\u0f24\0\u0f57\0\u0f8a\0\u0fbd\0\u02ca\0\u0ff0\0\u1023"+
    "\0\u1056\0\u02ca\0\u1089\0\u02ca\0\146\0\u10bc\0\u10ef\0\u1122"+
    "\0\u02ca\0\146\0\u1155\0\u02ca\0\u1188\0\u11bb\0\u11ee\0\u1221"+
    "\0\u02ca\0\146\0\146\0\u1254\0\u1287\0\u12ba\0\u12ed\0\u1320"+
    "\0\u1353\0\u02ca\0\u02ca\0\u02ca\0\146\0\u02ca\0\u1386\0\u13b9"+
    "\0\u02ca\0\u13ec\0\u141f\0\u1452\0\u02ca\0\146\0\u02ca\0\146"+
    "\0\u02ca";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\2\4\1\5\1\4\1\3\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\2\35\1\36\3\35\1\37"+
    "\1\40\2\35\1\41\1\42\1\35\1\43\1\35\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\1\3\2\4\2\5"+
    "\2\4\1\52\54\4\67\0\6\53\7\0\1\53\5\0"+
    "\25\53\30\0\1\21\66\0\2\10\54\0\1\54\4\0"+
    "\1\10\62\0\1\10\56\0\1\35\5\0\17\35\1\55"+
    "\5\35\30\0\1\35\5\0\15\35\1\56\1\35\1\57"+
    "\5\35\30\0\1\35\5\0\1\60\6\35\1\61\5\35"+
    "\1\62\7\35\30\0\1\35\5\0\4\35\1\63\20\35"+
    "\30\0\1\35\5\0\12\35\1\64\1\65\11\35\30\0"+
    "\1\35\5\0\1\66\14\35\1\67\4\35\1\70\2\35"+
    "\30\0\1\35\5\0\25\35\30\0\1\35\5\0\5\35"+
    "\1\71\6\35\1\72\10\35\30\0\1\35\5\0\22\35"+
    "\1\73\2\35\30\0\1\35\5\0\17\35\1\74\2\35"+
    "\1\75\2\35\30\0\1\35\5\0\23\35\1\76\1\35"+
    "\30\0\1\35\5\0\17\35\1\77\5\35\30\0\1\35"+
    "\5\0\7\35\1\100\15\35\43\0\1\101\6\0\1\102"+
    "\71\0\1\103\21\0\1\104\72\0\1\35\5\0\17\35"+
    "\1\105\5\35\30\0\1\35\5\0\15\35\1\106\7\35"+
    "\30\0\1\35\5\0\4\35\1\107\20\35\30\0\1\35"+
    "\5\0\20\35\1\110\4\35\5\0\1\111\22\0\1\35"+
    "\5\0\1\112\24\35\30\0\1\35\5\0\13\35\1\113"+
    "\11\35\30\0\1\35\5\0\5\35\1\114\17\35\30\0"+
    "\1\35\5\0\20\35\1\115\4\35\5\0\1\116\22\0"+
    "\1\35\5\0\16\35\1\117\6\35\30\0\1\35\5\0"+
    "\12\35\1\120\12\35\30\0\1\35\5\0\17\35\1\121"+
    "\5\35\30\0\1\35\5\0\14\35\1\122\10\35\30\0"+
    "\1\35\5\0\16\35\1\123\6\35\30\0\1\35\5\0"+
    "\13\35\1\124\11\35\30\0\1\35\5\0\21\35\1\125"+
    "\3\35\30\0\1\35\5\0\10\35\1\126\14\35\4\0"+
    "\1\127\23\0\1\35\5\0\22\35\1\130\2\35\30\0"+
    "\1\35\5\0\10\35\1\131\14\35\4\0\1\132\47\0"+
    "\1\133\54\0\1\127\20\0\1\127\23\0\1\35\5\0"+
    "\1\134\24\35\30\0\1\35\5\0\12\35\1\135\12\35"+
    "\30\0\1\35\5\0\1\136\24\35\30\0\1\35\5\0"+
    "\4\35\1\137\20\35\42\0\1\140\50\0\1\35\5\0"+
    "\17\35\1\141\5\35\30\0\1\35\5\0\4\35\1\142"+
    "\20\35\30\0\1\35\5\0\1\143\24\35\30\0\1\35"+
    "\5\0\4\35\1\144\20\35\42\0\1\145\50\0\1\35"+
    "\5\0\21\35\1\146\3\35\30\0\1\35\5\0\20\35"+
    "\1\130\4\35\5\0\1\147\22\0\1\35\5\0\2\35"+
    "\1\150\22\35\30\0\1\35\5\0\22\35\1\151\2\35"+
    "\30\0\1\35\5\0\1\35\1\152\23\35\30\0\1\35"+
    "\5\0\16\35\1\153\6\35\30\0\1\35\5\0\21\35"+
    "\1\154\3\35\57\0\1\155\33\0\1\35\5\0\4\35"+
    "\1\156\20\35\30\0\1\35\5\0\12\35\1\157\12\35"+
    "\50\0\1\160\72\0\1\161\32\0\1\35\5\0\24\35"+
    "\1\162\30\0\1\35\5\0\4\35\1\163\20\35\30\0"+
    "\1\35\5\0\11\35\1\164\13\35\6\0\1\165\21\0"+
    "\1\35\5\0\1\166\24\35\30\0\1\35\5\0\1\35"+
    "\1\167\23\35\30\0\1\35\5\0\22\35\1\170\2\35"+
    "\30\0\1\35\5\0\24\35\1\171\42\0\1\172\50\0"+
    "\1\35\5\0\21\35\1\173\3\35\30\0\1\35\5\0"+
    "\21\35\1\174\3\35\30\0\1\35\5\0\4\35\1\175"+
    "\20\35\30\0\1\35\5\0\22\35\1\176\2\35\30\0"+
    "\1\35\5\0\2\35\1\177\22\35\40\0\1\200\52\0"+
    "\1\35\5\0\4\35\1\201\20\35\42\0\1\202\77\0"+
    "\1\203\33\0\1\35\5\0\1\204\24\35\30\0\1\35"+
    "\5\0\2\35\1\205\22\35\30\0\1\35\5\0\1\206"+
    "\24\35\30\0\1\35\5\0\12\35\1\207\12\35\30\0"+
    "\1\35\5\0\10\35\1\210\14\35\4\0\1\211\23\0"+
    "\1\35\5\0\17\35\1\212\5\35\30\0\1\35\5\0"+
    "\21\35\1\213\3\35\30\0\1\35\5\0\7\35\1\214"+
    "\15\35\45\0\1\215\45\0\1\35\5\0\14\35\1\216"+
    "\10\35\30\0\1\35\5\0\21\35\1\217\3\35\30\0"+
    "\1\35\5\0\2\35\1\220\22\35\30\0\1\35\5\0"+
    "\21\35\1\221\3\35\30\0\1\35\5\0\15\35\1\222"+
    "\7\35\53\0\1\223\37\0\1\35\5\0\4\35\1\224"+
    "\20\35\30\0\1\35\5\0\11\35\1\225\13\35\6\0"+
    "\1\226\21\0\1\35\5\0\14\35\1\227\10\35\52\0"+
    "\1\230\40\0\1\35\5\0\17\35\1\231\5\35\7\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5253];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\6\11\1\1\7\11\1\1\2\11\20\1\4\11"+
    "\2\1\1\11\2\0\24\1\1\11\2\0\1\11\4\1"+
    "\1\0\4\1\1\0\10\1\1\0\2\1\2\0\4\1"+
    "\1\11\4\1\1\11\1\1\1\0\5\1\1\0\2\1"+
    "\2\0\3\1\1\11\4\1\1\11\5\1\1\0\1\1"+
    "\2\11\5\1\1\0\3\1\1\11\5\1\1\0\2\1"+
    "\1\11\1\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
	public static int errores = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexicalElements(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.out.println("Error. Caracter illegal: " + yytext() + "en Línea: " + (yyline + 1) + ", Columna: " + (yycolumn + 1));
					errores++;
            }
            // fall through
          case 44: break;
          case 2:
            { 
            }
            // fall through
          case 45: break;
          case 3:
            { System.out.print(yytext());
            }
            // fall through
          case 46: break;
          case 4:
            { yybegin(BLOCK_COMMENT);
            }
            // fall through
          case 47: break;
          case 5:
            { return new Symbol(sym.MOD,yycolumn,yyline,yytext());
            }
            // fall through
          case 48: break;
          case 6:
            { return new Symbol(sym.OPREL,yycolumn,yyline,yytext());
            }
            // fall through
          case 49: break;
          case 7:
            { return new Symbol(sym.PARDER,yycolumn,yyline,yytext());
            }
            // fall through
          case 50: break;
          case 8:
            { return new Symbol(sym.PARIZQ,yycolumn,yyline,yytext());
            }
            // fall through
          case 51: break;
          case 9:
            { return new Symbol(sym.MULT,yycolumn,yyline,yytext());
            }
            // fall through
          case 52: break;
          case 10:
            { return new Symbol(sym.SUM,yycolumn,yyline,yytext());
            }
            // fall through
          case 53: break;
          case 11:
            { return new Symbol(sym.COMMA,yycolumn,yyline,yytext());
            }
            // fall through
          case 54: break;
          case 12:
            { return new Symbol(sym.RES,yycolumn,yyline,yytext());
            }
            // fall through
          case 55: break;
          case 13:
            { return new Symbol(sym.DIV,yycolumn,yyline,yytext());
            }
            // fall through
          case 56: break;
          case 14:
            { return new Symbol(sym.INT,yycolumn,yyline,yytext());
            }
            // fall through
          case 57: break;
          case 15:
            { return new Symbol(sym.COLON,yycolumn,yyline,yytext());
            }
            // fall through
          case 58: break;
          case 16:
            { return new Symbol(sym.SEMICOLON,yycolumn,yyline,yytext());
            }
            // fall through
          case 59: break;
          case 17:
            { return new Symbol(sym.ASSIGNMENT,yycolumn,yyline,yytext());
            }
            // fall through
          case 60: break;
          case 18:
            { return new Symbol(sym.ID,yycolumn,yyline,yytext());
            }
            // fall through
          case 61: break;
          case 19:
            { return new Symbol(sym.SBRACKETDER,yycolumn,yyline,yytext());
            }
            // fall through
          case 62: break;
          case 20:
            { return new Symbol(sym.SBRACKETIZQ,yycolumn,yyline,yytext());
            }
            // fall through
          case 63: break;
          case 21:
            { return new Symbol(sym.BRACKETDER,yycolumn,yyline,yytext());
            }
            // fall through
          case 64: break;
          case 22:
            { return new Symbol(sym.BRACKETIZQ,yycolumn,yyline,yytext());
            }
            // fall through
          case 65: break;
          case 23:
            { yybegin(YYINITIAL);
            }
            // fall through
          case 66: break;
          case 24:
            { return new Symbol(sym.IF, yycolumn, yyline, yytext());
            }
            // fall through
          case 67: break;
          case 25:
            { return new Symbol(sym.ORELSE, yycolumn, yyline, yytext());
            }
            // fall through
          case 68: break;
          case 26:
            { return new Symbol(sym.CHAR,yycolumn,yyline,yytext());
            }
            // fall through
          case 69: break;
          case 27:
            { return new Symbol(sym.FOR, yycolumn, yyline, yytext());
            }
            // fall through
          case 70: break;
          case 28:
            { return new Symbol(sym.CASE, yycolumn, yyline, yytext());
            }
            // fall through
          case 71: break;
          case 29:
            { return new Symbol(sym.ELSE, yycolumn, yyline, yytext());
            }
            // fall through
          case 72: break;
          case 30:
            { return new Symbol(sym.BOOL,yycolumn,yyline,yytext());
            }
            // fall through
          case 73: break;
          case 31:
            { return new Symbol(sym.ARRAY, yycolumn, yyline, yytext());
            }
            // fall through
          case 74: break;
          case 32:
            { return new Symbol(sym.BREAK, yycolumn, yyline, yytext());
            }
            // fall through
          case 75: break;
          case 33:
            { return new Symbol(sym.EMPTY,yycolumn,yyline,yytext());
            }
            // fall through
          case 76: break;
          case 34:
            { return new Symbol(sym.INPUT, yycolumn, yyline, yytext());
            }
            // fall through
          case 77: break;
          case 35:
            { return new Symbol(sym.WHILE, yycolumn, yyline, yytext());
            }
            // fall through
          case 78: break;
          case 36:
            { return new Symbol(sym.NUMBER, yycolumn, yyline, yytext());
            }
            // fall through
          case 79: break;
          case 37:
            { return new Symbol(sym.OUTPUT, yycolumn, yyline, yytext());
            }
            // fall through
          case 80: break;
          case 38:
            { return new Symbol(sym.SWITCH, yycolumn, yyline, yytext());
            }
            // fall through
          case 81: break;
          case 39:
            { return new Symbol(sym.BOOLEAN, yycolumn, yyline, yytext());
            }
            // fall through
          case 82: break;
          case 40:
            { return new Symbol(sym.DEFAULT, yycolumn, yyline, yytext());
            }
            // fall through
          case 83: break;
          case 41:
            { return new Symbol(sym.COMEBACK, yycolumn, yyline, yytext());
            }
            // fall through
          case 84: break;
          case 42:
            { return new Symbol(sym.FUNCTION, yycolumn, yyline, yytext());
            }
            // fall through
          case 85: break;
          case 43:
            { return new Symbol(sym.CHARACTER, yycolumn, yyline, yytext());
            }
            // fall through
          case 86: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String[] argv) {
    if (argv.length == 0) {
      System.out.println("Usage : java LexicalElements [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          // Side-effect: is encodingName valid?
          java.nio.charset.Charset.forName(encodingName);
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        LexicalElements scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new LexicalElements(reader);
          while ( !scanner.zzAtEOF ) scanner.next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
