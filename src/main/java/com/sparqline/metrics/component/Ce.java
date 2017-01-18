/**
 * 
 */
package com.sparqline.metrics.component;


public class Ce /* extends ComponentMetric */{

    // /**
    // *
    // */
    // private static final long /* serialVersionUID = 3567737741649126324L */;

    // /**
    // * @param name
    // * @param desc
    // * @param acronym
    // * @param scope
    // * @param graph
    // * @param entities
    // */
    // public Ce(String name, String desc, String acronym, MetricScope scope,
    // ProgramEntity entity, CodeGraph graph)
    // {
    // super(name, desc, acronym, scope, entity, graph);
    // }

    // /**
    // * @param graph
    // * @param entities
    // * @return
    // */
    // public static Ce getInstance(final ProgramEntity entity, final CodeGraph
    // graph)
    // {
    // return new Ce(
    // "Efferent Coupling",
    // "Measures the total number of external classes coupled to classes of a component due to outgoing coupling (coupling to classes external to the component). Each class counts only once. Zero, if the component does not contain classes or if external classes are not used by the component's classes. Ce = |Coupled(p)|. Where Coupled(p) = { c \\in succ(CIP(p), coupling^Ce) and c \\in COP(p)}, set of classes coupled to p over afferent coupling. COP(p) = {c \\in class^Ce | c \\in class^Ce | c \\not_in CIP(p)}, set of classes outside p. CIP(p) = succ^*(p, contains^Ce), set of classes inside/contained in P.",
    // "Ce", MetricScope.PackageLevel, entity, graph);
    // }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    // @Override
    // public double measure()
    // {
    // double ce = 0;

    // if (entity instanceof ComponentEntity)
    // {
    // Set<ClassOrInterfaceEntity> componentClasses = new
    // HashSet<>(((ComponentEntity) entity).getContents());
    // Set<ClassOrInterfaceEntity> systemClasses =
    // getSystemClassesExcludingComponentClasses(componentClasses);
    // Set<ClassOrInterfaceEntity> ceClasses = new HashSet<>();

    // for (ClassOrInterfaceEntity comCls : componentClasses)
    // {
    // List<Connection> conns = new LinkedList<Connection>();
    // conns.addAll(graph.getEdgesContainingRelationType(comCls,
    // AssociationRelationshipType.DirectedAssociation));
    // conns.addAll(graph.getEdgesContainingRelationType(comCls,
    // DirectedRelationshipType.Generalization));
    // conns.addAll(graph.getEdgesContainingRelationType(comCls,
    // DirectedRelationshipType.Dependency));
    // conns.addAll(graph
    // .getEdgesContainingRelationType(comCls,
    // DirectedRelationshipType.InterfaceRealization));
    // conns.addAll(graph.getEdgesContainingRelationType(comCls,
    // DirectedRelationshipType.Realization));
    // conns.addAll(graph.getEdgesContainingRelationType(comCls,
    // DirectedRelationshipType.Usage));

    // for (Connection conn : conns)
    // {
    // ProgramEntity pe = graph.getState().getDest(conn);
    // if (pe instanceof ClassOrInterfaceEntity)
    // {
    // ClassOrInterfaceEntity dest = (ClassOrInterfaceEntity) pe;
    // if (systemClasses.contains(dest))
    // {
    // ceClasses.add(dest);
    // }
    // }
    // }
    // }

    // ce = ceClasses.size();
    // }

    // return ce;
    // }

    // /**
    // * @param componentClasses
    // * @return
    // */
    // private Set<ClassOrInterfaceEntity>
    // getSystemClassesExcludingComponentClasses(
    // Set<ClassOrInterfaceEntity> componentClasses)
    // {
    // Set<ClassOrInterfaceEntity> systemClasses = new HashSet<>();

    // for (ProgramEntity entity : graph.getClasses())
    // {
    // if (entity instanceof ClassOrInterfaceEntity)
    // systemClasses.add((ClassOrInterfaceEntity) entity);
    // }

    // for (ProgramEntity entity : graph.getInterfaces())
    // {
    // if (entity instanceof ClassOrInterfaceEntity)
    // systemClasses.add((ClassOrInterfaceEntity) entity);
    // }

    // try
    // {
    // systemClasses = SetOperations.difference(systemClasses,
    // componentClasses);
    // }
    // catch (SetOperationsException e)
    // {
    // systemClasses.clear();
    // }

    // return systemClasses;
    // }

}
