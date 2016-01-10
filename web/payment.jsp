<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf" %>
<main>
    <section class="main">
        <div class="container-fluid">
            <div class="row">

                <div class="well well-sm">
                    <h2 class="text-center"><strong>The Exiled: Siege</strong></h2>
                    <h4 class="text-center">by <strong>Author (First name, Last name)</strong></h4>
                </div>

            </div>
            <div class="row">

                <div class="well text-center bg-my-well">
                    <h4><strong>Kickstarter is not a store.</strong></h4>
                    <h5>It's a way to bring creative projects to life.</h5>
                    <p>
                        <small> Kickstarter does not guarantee projects or investigate a creator's ability to complete their project. It is the responsibility of the project creator to complete their project as promised, and the claims of this project are theirs alone.
                        </small>
                    </p>
                </div>

            </div>
            <div class="row">
                <div class="col-md-8">
                    <h3>
                        Payment information
                    </h3> 
                    <p>
                        Your payment method will not be charged at this time. If the project is successfully funded, your payment method will be charged $1.00 when the project ends.
                    </p>
                    <h3>
                        Card information 
                    </h3> 
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="inputName" class="col-sm-2 control-label">Name</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputName" placeholder="Name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputCardNumber" class="col-sm-2 control-label">Card number</label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <input type="text" class="form-control" id="inputCardNumber" placeholder="Card number">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-credit-card" ></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputName" class="col-sm-2 control-label">Expiration</label>
                            <div class="col-sm-2">
                                <select  class="form-control select-month" id="inputMonth" data-toggle="tooltip" data-placement="left" title="month">
                                    <option>01</option>
                                    <option>02</option>
                                    <option>03</option>
                                    <option>04</option>
                                    <option>05</option>
                                    <option>06</option>
                                    <option>07</option>
                                    <option>08</option>
                                    <option>09</option>
                                    <option>10</option>
                                    <option>11</option>
                                    <option>12</option>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <select  class="form-control"  id="inputYear" data-toggle="tooltip" data-placement="left" title="year">
                                    <option>2016</option>
                                    <option>2017</option>
                                    <option>2018</option>
                                    <option>2019</option>
                                    <option>2020</option>

                                </select>
                            </div>
                            <label for="inputCvn" class="col-sm-2 control-label">CVN</label>
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input type="text" class="form-control" id="inputCvn">
                                    <span class="input-group-addon">
                                        <a class="link-info-cvn" data-toggle="tooltip" title="The 3 or 4 digit number on the back of a Visa, Discover, and MasterCard or the front of an American Express card.">
                                            <span class="glyphicon glyphicon-question-sign" ></span>
                                        </a>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Remember this card for future pledges
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Pledge</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-4">
                    <div class="well">
                        <h5><strong>PLEDGE AMOUNT</strong></h5>
                        <h3><strong>$1.00</strong></h3>
                        <hr>
                        <h5><strong>SELECTED REWARD</strong></h5>
                        <p>You or your character's name will be listed on the credits page as one of our supporters: the army of the night.
                        </p>
                        <strong>Estimated delivery:</strong>
                        <br>
                        Dec 2016
                        <h4 >
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Edit
                            </a>
                        </h4>
                        <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <form role="form">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Pledge amount</label>
                                    <strong> <input type="text" class="form-control" id="exampleInputEmail1" value="$1"></strong>
                                </div>
                                <button type="submit" class="btn btn-success btn-block"><strong>Continue</strong></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
    </section>
</main>
<%@include file="WEB-INF/jspf/footer.jspf" %>
