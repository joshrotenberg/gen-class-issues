(ns gen-class-issue.my-concrete-thing
  (:import stuff.MyAbstractThing)
  (:gen-class
   :name stuff.MyConcreteThing
   :prefix ma-
   :state ma-state
   :methods [[^{Override {}} doStuff [int] void]]
   :constructors {[int int] [int int]}
   :extends stuff.MyAbstractThing))

(gen-class
 :name stuff.MyConcreteThing$Builder
 :prefix my-builder-
 :init binit
 :state bstate
 :constructors {[] []}
 :methods [[addFoo [int] Object]
           [addBar [int] Object]
           [getFoo [] int]
           [getBar [] int]
           [build [] Object]])

(defn- my-builder-binit []
  [[] (atom {:foo 0 :bar 0})])

(defn- my-builder-addFoo [this i]
  (swap! (.bstate this) assoc :foo i)
  this)

(defn- my-builder-addBar [this i]
  (swap! (.bstate this) assoc :bar i)
  this)

(defn- my-builder-getFoo [this]
  (:foo @(.bstate this)))

(defn- my-builder-getBar [this]
  (:bar @(.bstate this)))

;;(defn- my-builder-build [this]
;;  (stuff.MyConcreteThing. (:foo @(.bstate this)) (:bar @(.bstate this))))

(defn- ma-init [f b]
  ([] [atom {:foo f :bar b}]))

(defn- ma-doStuff [this i]
  (prn "in do stuff" i))
