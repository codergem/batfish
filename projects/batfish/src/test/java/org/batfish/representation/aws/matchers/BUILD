load("@rules_java//java:defs.bzl", "java_library")

package(
    default_testonly = True,
    default_visibility = ["//visibility:public"],
)

java_library(
    name = "matchers",
    srcs = glob([
        "*.java",
    ]),
    deps = [
        "//projects/batfish-common-protocol:common",
        "//projects/batfish/src/main/java/org/batfish/representation/aws",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_guava_guava",
        "@maven//:org_hamcrest_hamcrest",
    ],
)
