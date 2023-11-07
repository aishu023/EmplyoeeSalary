
class LineList {
    private Vector<Line> list_of_lines;

    public LineList(Vector<Line> lines) {
        this.list_of_lines = lines;
    }

    public Line getLineWithMaxLength() {
        if (list_of_lines.isEmpty()) {
            return null;
        }

        Line maxLengthLine = list_of_lines.get(0);
        double maxLength = maxLengthLine.getLineLength();

        for (Line line : list_of_lines) {
            double length = line.getLineLength();
            if (length > maxLength) {
                maxLength = length;
                maxLengthLine = line;
            }
        }

        return maxLengthLine;
    }

    public Vector<Line> getLinesFromStartingPoint(Point p) {
        Vector<Line> linesStartingFromPoint = new Vector<Line>();
        for (Line line : list_of_lines) {
            if (line.getStart().getX() == p.getX() && line.getStart().getY() == p.getY()) {
                linesStartingFromPoint.add(line);
            }
        }
        return linesStartingFromPoint;
    }
}