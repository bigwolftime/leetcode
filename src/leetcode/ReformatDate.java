package leetcode;

/**
 * 转变日期格式
 * https://leetcode.cn/problems/reformat-date/description/
 *
 * @author liuxin
 * @date 2024/6/22 16:04
 */
public class ReformatDate {

    private static String reformatDate(String date) {
        String[] dateArr = date.split(" ");
        String day = dateArr[0];
        String month = dateArr[1];
        String year = dateArr[2];

        return formatYear(year) + "-" + formatMonth(month) + "-" + formatDay(day);
    }

    private static String formatDay(String day) {
        switch (day) {
            case "1st":
                return "01";
            case "2nd":
                return "02";
            case "3rd":
                return "03";
            case "4th":
                return "04";
            case "5th":
                return "05";
            case "6th":
                return "06";
            case "7th":
                return "07";
            case "8th":
                return "08";
            case "9th":
                return "09";
            default:
                return day.substring(0, day.length() - 2);
        }
    }

    private static String formatMonth(String month) {
        switch (month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
            default:
                return month;
        }
    }

    private static String formatYear(String year) {
        return year;
    }


    public static void main(String[] args) {

    }

}
