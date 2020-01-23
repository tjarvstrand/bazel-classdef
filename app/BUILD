
load(
    "@rules_scala_annex//rules:scala.bzl",
    "scala_test",
)
scala_test(
    name = "test",
    size = "small",
    srcs = glob(["src/test/scala/**/*.scala"]),
    deps = ["@maven//:com_fasterxml_jackson_module_jackson_module_scala_2_12",
            "@maven//:com_fasterxml_jackson_core_jackson_databind",
            "@maven//:org_scalatest_scalatest_2_12",
            "@maven//:org_scalactic_scalactic_2_12",
           ])
