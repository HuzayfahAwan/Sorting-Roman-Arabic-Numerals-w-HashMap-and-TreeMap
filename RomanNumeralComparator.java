import java.util.Comparator;

/**
 * this class implements interface Comparator to aid the sortedRomanToArabicMap TreeMap in knowing where each RomanNumeral object being put in the
 * TreeMap belongs in terms of it being greater than, less than, or equal to other objects.
 * @author Huzayfah Hayyan Awan
 *
 */
public class RomanNumeralComparator implements Comparator <RomanNumeral> {

	/**
	 * this method comes from interface Comparator and its body simply compare two RomanNumeral objects to tell the sortedRomanNumToArabicMap TreeMap
	 * where each RomanNumeral objects belongs when sorting each RomanNumeral objects Arabic values.
	 */
	public int compare(RomanNumeral arabicNum1, RomanNumeral arabicNum2) {
		return arabicNum1.compareTo(arabicNum2);
	}
	
}
