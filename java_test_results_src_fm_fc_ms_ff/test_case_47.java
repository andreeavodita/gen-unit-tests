/*
MicroSvgParser  static Group readSvg(InputStream in, DoubleProperty svgWidth, DoubleProperty svgHeight, ObjectPropertyPaint> svgFill) throws Exception  NodeList paths = (NodeList) XPathFactory.newDefaultInstance().newXPath().evaluate("/svg/g/path", DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in), XPathConstants.NODESET); Group group = new Group(); for (int i = 0; i  paths.getLength(); i++)  NamedNodeMap attributes = paths.item(i).getAttributes(); SVGPath path = new SVGPath(); var fill = attributes.getNamedItem("fill"); if (fill!= null) path.setFill(fill.getTextContent().equals("none")? Color.TRANSPARENT : Paint.valueOf(fill.getTextContent())); else if (svgFill.get()!= null) path.setFill(svgFill.get()); var fillRule = attributes.getNamedItem("fill-rule"); if (fillRule!= null) switch (fillRule.getTextContent())  case "evenodd": path.setFillRule(FillRule.EVEN_ODD); break; case "nonzero": path.setFillRule(FillRule.NON_ZERO); break; default: log.warn("Unknown fill-rule: " + fillRule.getTextContent()); break;  var d = attributes.getNamedItem("d"); if (d!= null) path.setContent(d
*/

@Test public void testReadSvg() throws Exception  InputStream in = new DoublePropertyPaint>(); MicroSvgParser.readSvg(InputStream in, DoublePropertyPaint> svgFill, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.newDefaultInstance().newDefaultInstance().newDefaultInstance().get(0).getFillRule("node"); assertEquals("/svg/path", MicroSvgParser.readSvg(InputStream in, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO)); assertEquals("/svg/path", MicroSvgParser.readSvg(InputStream in, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO)); assertEquals("/svg/path", MicroSvgParser.readSvg(InputStream in, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO, DoubleProperty.NON_ZERO)); assertEqual