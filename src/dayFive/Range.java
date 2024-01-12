package dayFive;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Range {
    Boolean isMapped;
    BigInteger start;
    BigInteger end;

    Range(BigInteger s, BigInteger e) {
        start = s;
        end = e;
        isMapped = false;
    }


    public static List<Range> mapRanges(List<Range> ranges, List<Range> sourceRanges, List<Range> destinationRanges) {
        List<Range> subRanges = splitRanges(ranges, sourceRanges);
        // System.out.println("SubRanges: " + subRanges);
        for (Range subRange : subRanges) {
            if(subRange.isMapped) continue;
            for (int i = 0; i < sourceRanges.size(); i++) {
                Range sourceRange = sourceRanges.get(i);
                Range destinationRange = destinationRanges.get(i);
                if(!subRange.isZeroOverlap(sourceRange)) {
                    BigInteger offset = subRange.start.subtract(sourceRange.start);
                    subRange.start = destinationRange.start.add(offset);
                    subRange.end = destinationRange.end.subtract((sourceRange.end.subtract(subRange.end)));
                    subRange.isMapped = true;
                    break;
                }
            }
        }
        subRanges.forEach(e -> e.isMapped = false);
        return subRanges;
    }
    private static List<Range> splitRanges(List<Range> ranges, List<Range> sourceRanges) {
        ArrayList<Range> subRanges = new ArrayList<>();
        for(Range range : ranges) {
            subRanges.addAll(splitRange(sourceRanges, range));
        }
        return subRanges;
    }
    private static List<Range> splitRange(List<Range> sourceRanges, Range range) {
        Set<BigInteger> boundaryPoints = new TreeSet<>();
        boundaryPoints.add(range.start);
        boundaryPoints.add(range.end);

        for (Range sourceRange : sourceRanges) {
            boundaryPoints.add(sourceRange.start);
            boundaryPoints.add(sourceRange.end);
        }
        boundaryPoints.removeIf(point -> (point.compareTo(range.start) < 0 || point.compareTo(range.end) > 0));

        List<Range> subRanges = new ArrayList<>();
        BigInteger previousPoint = null;

        for (BigInteger point : boundaryPoints) {
            if (previousPoint != null) {
                subRanges.add(new Range(previousPoint, point));
            }
            previousPoint = point;
        }

        return subRanges;
    }



    public boolean isZeroOverlap(Range other) {
        if(this.start.compareTo(other.start) < 0)
            return this.end.compareTo(other.end) < 0;
        else if (this.start.compareTo(other.start) > 0)
            return this.end.compareTo(other.end) > 0;
        return false;
    }

    @Override
    public String toString() {
        return this.start + " " + this.end;
    }
}